package com.kirangs;

class Q {

	int num;
	boolean valueSet = false;

	public synchronized  void put(int num) {

		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Put : " + num);
		this.num = num;
		valueSet = true;
		notify();
	}

	public synchronized int get() {

		while (!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		valueSet = false;
		notify();
		return num;

	}
}

class Producer implements Runnable {

	Q q;

	public Producer() {
	}

	public Producer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Producer");
		t.start();
	}

	@Override
	public void run() {

		int i = 0;

		while (true) {

			q.put(i++);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

class Consumer implements Runnable {

	Q q;

	public Consumer() {
	}

	public Consumer(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	@Override
	public void run() {

		while (true) {
			System.out.println("Get : " + q.get());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ProducerConsumerThreadDemo {

	public static void main(String[] args) {

		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}

}
