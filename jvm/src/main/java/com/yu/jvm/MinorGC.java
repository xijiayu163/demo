package com.yu.jvm;

public class MinorGC {
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8 测试新对象分配在新生代Eden中。
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];// 出现一次Minor GC
		allocation4 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];

		// Heap
		// PSYoungGen total 9216K, used 7456K [0x00000000ff600000,
		// 0x0000000100000000, 0x0000000100000000)
		// eden space 8192K, 91% used
		// [0x00000000ff600000,0x00000000ffd48328,0x00000000ffe00000)
		// from space 1024K, 0% used
		// [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
		// to space 1024K, 0% used
		// [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
		// ParOldGen total 10240K, used 4096K [0x00000000fec00000,
		// 0x00000000ff600000, 0x00000000ff600000)
		// object space 10240K, 40% used
		// [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
		// Metaspace used 2696K, capacity 4486K, committed 4864K, reserved
		// 1056768K
		// class space used 288K, capacity 386K, committed 512K, reserved
		// 1048576K
	}

	/**
	 * VM参数：-verbose：gc-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails-XX：SurvivorRatio
	 * =8 -XX：PretenureSizeThreshold=3145728 3M,测试大对象直接分配在老年代中。
	 */
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[6 * _1MB];// 直接分配在老年代中
	}

	/**
	 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio =8 -XX:MaxTenuringThreshold=1
	 * -XX:+PrintTenuringDistribution 长期存活的对象会进入老年代
	 */
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		// 什么时候进入老年代取决于XX：MaxTenuringThreshold设置
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}

	/**
	 * VM参数：-verbose：gc-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails-XX：SurvivorRatio
	 * =8-XX：MaxTenuringThreshold=15 -XX：+PrintTenuringDistribution
	 * 动态年龄对象判定,不一定永远要求对象的年龄必须达到MaxTenuringThreshold才能晋升老年代。
	 */
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		// allocation1+allocation2大于survivo空间一半
		allocation2 = new byte[_1MB / 4];
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
	}

	/**
	 * VM参数：-Xms20M-Xmx20M-Xmn10M-XX：+PrintGCDetails-XX：SurvivorRatio=8-XX：-
	 * HandlePromotionFailure
	 * 空间分配担保
	 */
	public static void testHandlePromotion() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation1 = null;
		allocation4 = new byte[2 * _1MB];
		allocation5 = new byte[2 * _1MB];
		allocation6 = new byte[2 * _1MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * _1MB];
	}

	public static void main(String[] args) {
		// testAllocation();
		// testPretenureSizeThreshold();
		testTenuringThreshold();
	}
}
