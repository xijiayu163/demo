package com.yu.jvm;

/**
 * VM Args£º-Xss128k
 * 
 * @author zzm
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length£º" + oom.stackLength);
			throw e;
		}
	}
	
//	Exception in thread "main" java.lang.StackOverflowError
//	at com.yu.jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12)
}
