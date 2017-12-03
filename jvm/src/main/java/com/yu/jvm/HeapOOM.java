package com.yu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 测试堆溢出
 * -verbose:gc -Xms20m -Xmx20m -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8  -XX:+HeapDumpOnOutOfMemoryError
 * -Xmn10M：设置年轻代大小为10M
 * 整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小  持久代特指hotspot的方法区，但是会有分配瓶颈。hotspot
 * 申明将要废弃。
 * @author zzm
 */
public class HeapOOM {
	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
	
//	Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
}
