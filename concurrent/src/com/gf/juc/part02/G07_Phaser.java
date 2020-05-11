package com.gf.juc.part02;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * Phaser - ·Ö½×¶Î
 * 
 */
public class G07_Phaser {
	
	static MyPhaser mp = new MyPhaser();
	
	static Random r = new Random();
	
	private static class Person implements Runnable {
		
		String name;
		
		public Person(String name) {
			this.name = name;
		}
		
		private void arrive() {
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " arrived");
			mp.arriveAndAwaitAdvance();
		}
		
		private void eat() {
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " eat");
			mp.arriveAndAwaitAdvance();
		}
		
		private void leave() {
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " leave");
			mp.arriveAndAwaitAdvance();
		}

		private void hug() {
			if ("man".equals(name) || "woman".equals(name)) {
				try {
					Thread.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " hug");
				mp.arriveAndAwaitAdvance();
			} else {
				mp.arriveAndDeregister();
			}
		}
		
		@Override
		public void run() {
			arrive();
			
			eat();
			
			leave();
			
			hug();
		}
	}

	private static class MyPhaser extends Phaser {

		@Override
		protected boolean onAdvance(int phase, int registeredParties) {
			switch (phase) {
				case 0:
					System.out.println("All arrived....");
					return false;
				case 1:
					System.out.println("All eat over...");
					return false;
				case 2:
					System.out.println("All leave....");
					return false;
				case 3:
					System.out.println("Two hug...");
					return true;
				default:
					return true;
			}
		}
	}
	
	public static void main(String[] args) {
		mp.bulkRegister(7);
		for (int i=0; i<5; i++) {
			new Thread(new Person("t" + i)).start();
		}
		new Thread(new Person("man")).start();
		new Thread(new Person("woman")).start();
		
	}
	
}
