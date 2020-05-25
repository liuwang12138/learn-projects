package com.gf.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
	public static void main(String[] args) {
		Child c = new Child();
		c.wakeup();
	}
}

class Child {
	boolean cry = false;
	
	private static List<ChildObserver> list = new ArrayList<>();
	
	static {
		list.add(new Mum());
		list.add(new Dad());
		list.add(new Dog());
	}

	public void wakeup() {
		this.cry = true;
		ChildWakeEvent event = new ChildWakeEvent();
		
		for (ChildObserver o : list) {
			o.actionOnWeekUp(event);
		}
	}
}

interface Event<T> {
	T getSource();
}

class ChildWakeEvent implements Event<Child> {
	
	Child source;

	@Override
	public Child getSource() {
		return source;
	}
	
}

interface ChildObserver {
	void actionOnWeekUp(ChildWakeEvent e);
}

class Mum implements ChildObserver {
	private void feed() {
		System.out.println("mum feeding...");
	}
	@Override
	public void actionOnWeekUp(ChildWakeEvent e) {
		feed();
	}
}

class Dad implements ChildObserver {
	private void hug() {
		System.out.println("dad huging...");
	}
	@Override
	public void actionOnWeekUp(ChildWakeEvent e) {
		hug();
	}
}

class Dog implements ChildObserver {
	private void wang() {
		System.out.println("wang wang...");
	}
	@Override
	public void actionOnWeekUp(ChildWakeEvent e) {
		wang();
	}
}
