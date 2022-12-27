package com.kirangs;

/**
 * Here we have a scenario where two threads at the same time tries to update
 * this count via increment() method
 * 
 * we need to make sure that when t1 is executing that method t2 should not
 * execute that method and vice versa
 * 
 * we can do this by just adding synchronized keyword to method
 * 
 * when we don't make our method synchronized it does mean that our Counter is not Thread safe
 */
class Counter {

	int count;

//	public void increment() {
//		
//		count++;
//	}

	public synchronized void increment() {

		count++;
	}
}

public class ThreadSynchronizeDemo {

	public static void main(String[] args) throws InterruptedException {

		Counter counter = new Counter();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 1000; i++) {
					counter.increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 1000; i++) {
					counter.increment();
				}
			}
		});

		t1.start();
		t2.start();
		// let's ask main to stop until t1 finishes it's execution
		t1.join(); // without this line we will get 0 as ouput for line no 34
		t2.join();

		System.out.println("Count : " + counter.count);

	}

}
