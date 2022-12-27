package com.kirangs;

class A {

}

class B extends A implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i <= 50; i++) {
			System.out.print(i+" ");
		}
	}

}

class C extends A implements Runnable {

	@Override
	public void run() {

		for (int i = 51; i <= 100; i++) {
			System.out.print(i+" ");
		}

	}

}

public class ThreadsUsingRunnableInterfaceDemo {

	public static void main(String[] args) {

		B b = new B();
		C c = new C();

//		b.run();
//		c.run();

		//pass runnable instances here
		Thread thread1 = new Thread(b);
		Thread thread2 = new Thread(c);

		thread1.start();
		thread2.start();

	}

}
