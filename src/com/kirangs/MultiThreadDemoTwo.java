package com.kirangs;

/**
 * All threads created here extends Thread Class
 */
class Ten extends Thread {

	@Override
	public void run() {

		System.out.println("\nThread 1 started execution\n");
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Twenty extends Thread {

	@Override
	public void run() {

		System.out.println("\nThread 2 started execution\n");
		for (int i = 11; i <= 20; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Thirty extends Thread {

	@Override
	public void run() {

		System.out.println("\nThread 3 started execution\n");
		for (int i = 21; i <= 30; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class Sixty implements Runnable {

	@Override
	public void run() {

		for (int i = 51; i <= 60; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

public class MultiThreadDemoTwo {

	public static void main(String[] args) {

		Ten thread1 = new Ten();
		Twenty thread2 = new Twenty();
		Thirty thread3 = new Thirty();

		// anonymous class implementing Runnable interface
		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				System.out.println("\nThread 4 started execution\n");
				for (int i = 31; i <= 40; i++) {
					System.out.print(i + " ");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};

		Thread thread4 = new Thread(runnable);

		// using lambda expression
		Runnable runnable2 = () -> {

			System.out.println("\nThread 5 started execution\n");
			for (int i = 41; i <= 50; i++) {
				System.out.print(i + " ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread5 = new Thread(runnable2);

		Runnable runnable3 = new Sixty();
		Thread thread6 = new Thread(runnable3);

		thread1.start(); // start() calls run method implementation of thread1
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();

	}

}