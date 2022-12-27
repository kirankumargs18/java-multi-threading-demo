package com.kirangs;

public class JoinAndIsAliveThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		Runnable runnable1 = () -> {

			for (int i = 1; i <= 10; i++) {
				System.out.println(" Bhaya ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable runnable2 = () -> {

			for (int i = 1; i <= 10; i++) {
				System.out.println(" Kiran ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);

		t1.start();
		t2.start();
		
		
		System.out.println("t1 alive : "+t1.isAlive());
		
		//main thread waits for t1 to finish it's execution
		t1.join();
		
		//main thread waits for t2 to finish it's execution
		t2.join();
		
		//will tell main thread to hold on until t1, t2 finishes their execution
		//this can be done by using join() of Thread class
		System.out.println("Bye");
		
		System.out.println("t1 alive : "+t1.isAlive());
		

		/**
		 * actually here we have 3 threads which have been executed now, those are t1,t2
		 * and main thread
		 */
		

	}

}
