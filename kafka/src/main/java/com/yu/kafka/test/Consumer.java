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
//		props.put("zookeeper.connect", "192.168.8.88:2181");
		props.put("bootstrap.servers", "192.168.8.88:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("auto.offset.reset", "earliest");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("test"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records)
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
		}
	}

	
	public static void main(String[] args) {
		System.out.println("xxxx");
		testAutoCommit();
	}
}
