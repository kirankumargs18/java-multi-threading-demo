package com.kirangs;

class Typing extends Thread{
	@Override
	public void run() {
		
		for(int i=1;i<=20;i++) {
//			System.out.println("Typing........."+Thread.currentThread()); //Typing.........Thread[Typing Thread,1,main]
			System.out.println("Typing........."+Thread.currentThread().getPriority()); //Typing.........1
		}
	}
}
class SpellCheck implements Runnable{

	@Override
	public void run() {
		
		for(int i=1;i<=20;i++) {
//			System.out.println("Spell Checking....."+Thread.currentThread());
			System.out.println("Spell Checking......"+Thread.currentThread().getPriority());
		}
	}
	
}
public class ThreadPriorityDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1=new Typing();
		
		Runnable runnable=new SpellCheck();
//		Thread thread2=new Thread(runnable);
		Thread thread2=new Thread(runnable,"Spell Check Thread");
		thread1.setName("Typing Thread");
		
		/**
		 * Thread priority
		 * Range of priorities : 1-10 
		 * */
//		thread1.setPriority(7);
//		thread2.setPriority(1);
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		System.out.println(thread1.getPriority()); //default priority is 5
		System.out.println(thread2.getPriority());
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		
//		thread2.setName("Spell Check Thread");
		
		System.out.println(thread1.getName());
		System.out.println(thread2.getName());
		
		
	}

}
