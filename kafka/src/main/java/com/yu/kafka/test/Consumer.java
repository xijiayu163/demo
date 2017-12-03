package com.yu.kafka.test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.util.Log4jConfigurer;

public class Consumer {
	static{
		try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试步骤：
	 * 1 启动kafka broker 9092   
	 * 		bin/zookeeper-server-start.sh config/zookeeper.properties
	 * 		bin/kafka-server-start.sh config/server.properties
	 * 2 创建1个分区1个复制银子的主题test 
	 * 		bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
	 * 3 启动一个生产者，往名为test的主题发送消息
	 * 		bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
	 * 		This is a message
	 * 		This is another message
	 * 4 启动本方法
	 *		
	 * @author yuxijia
	 *
	 */
	public static void testAutoCommit() {
		Properties props = new Properties();
		//从哪个borker消费消息，可以为列表
		props.put("bootstrap.servers", "192.168.8.88:9092");
		//当前消费者所属的组编号，kafka保证每个partition中的消息只被同组内的一个消费者消费。
		//同一个partition的消息可以被多个组消费。
		props.put("group.id", "test");
		//自动提交
		props.put("enable.auto.commit", "true");
		//每秒钟自动提交一次偏移量
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		//表示从最早的消息消费起未被该组消费的消息，该模式可以达到队列的效果，即正常情况下消费所有消息。
		//如果不设置表示从偏移量开始消费，偏移量保存在kafka的broker中。
		//props.put("auto.offset.reset", "earliest");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("test","my-replicated-topic"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records){
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
			}
		}
	}

	
	public static void main(String[] args) {
		System.out.println("xxxx");
		testAutoCommit();
	}
}
