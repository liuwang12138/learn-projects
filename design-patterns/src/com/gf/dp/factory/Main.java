package com.gf.dp.factory;

public class Main {
	
	public static void main(String[] args) {
		AbstractFactory factory = new MagicFactory();
		
		Food f = factory.createFood();
		f.printName();
		Weapon w = factory.createWeapon();
		w.shoot();
		Movable m = factory.createMovable();
		m.go();
	}
	

}
