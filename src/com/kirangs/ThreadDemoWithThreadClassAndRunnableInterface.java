package com.kirangs;

/**
 * class which extends Thread
 */
class FirstTenNumbers extends Thread {

	@Override
	public void run() {

		for (int i = 1; i <= 10; i++) {

			System.out.print(i + " ");
		}
	}
}

/**
 * class which implements Runnable Interface
 */
class NextTenNumbers implements Runnable {

	@Override
	public void run() {

		for (int i = 11; i <= 20; i++) {
			System.out.print(i + " ");
		}
	}

}

public class ThreadDemoWithThreadClassAndRunnableInterface {

	public static void main(String[] args) {

		Thread thread1 = new FirstTenNumbers();

		Thread thread2 = new Thread(new NextTenNumbers());

		thread1.start();
		thread2.start();

	}

}
