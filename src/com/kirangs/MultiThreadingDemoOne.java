package com.kirangs;

/**
 * by default everything is executed by main thread
 * */

/**
 * class Hi without extending Thread
 */
//class Hi {
//
//	public void show() {
//
//		for (int i = 1; i <= 5; i++) {
//			System.out.println("Hi");
//		}
//	}
//
//}
/**
 * class Hi with extending Thread
 * Object of this class is a thread 
 * we can start it by using object.start() also
 */
class Hi extends Thread {

	/**
	 * change show() to run() so that thread can execute this method when we call thread.start()
	 * */
	public void run() {

		for (int i = 1; i <= 5; i++) {
			System.out.println("Hi");
		}
	}

}

/**
 * class Hello without extending Thread
 */
//class Hello {
//
//	public void show() {
//
//		for (int i = 1; i <= 5; i++) {
//
//			System.out.println("Hello");
//		}
//	}
//}

/**
 * class Hello with extending Thread
 */
class Hello extends Thread {

	/**
	 * change show() to run() so that thread can execute this method when we call thread.start()
	 * */
	public void run() {

		for (int i = 1; i <= 5; i++) {

			System.out.println("Hello");
		}
	}
}

public class MultiThreadingDemoOne {

	public static void main(String[] args) throws InterruptedException {

//		System.out.print("Kiran");
//		Thread.sleep(1000); // this will pause current thread that is main thread for a second
//
//		System.out.print(" Kumar");
//		Thread.sleep(1000);
//
//		System.out.println(" G S");
//		Thread.sleep(1000);

		Hi object1 = new Hi();
		Hello object2 = new Hello();
		
		object1.start(); //when we say start here in internally tries to execute run() method
		object2.start(); // we should have run method in thread
	

		

	}

}
