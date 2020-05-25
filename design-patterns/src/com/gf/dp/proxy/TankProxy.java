package com.gf.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class TankProxy {
	public static void main(String[] args) {
		Tank tank = new Tank();
		
		Movable m = (Movable)Proxy.newProxyInstance(Tank.class.getClassLoader(), 
										   new Class[] {Movable.class}, 
										   new InvocationHandler() {
											@Override
											public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
												long startTime = System.currentTimeMillis();
												System.out.println("starting....");
												Object o = method.invoke(tank, args);
												System.out.println("ended!");
												long endTime = System.currentTimeMillis();
												System.out.println("Total time: " + (endTime - startTime));
												return o;
											}
										});
		
		m.move();
	}
}

interface Movable {
	void move();
}

class Tank implements Movable {
	
	Random random = new Random();
	
	@Override
	public void move() {
		System.out.println("Tank Moving...");
		try {
			Thread.sleep(random.nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
