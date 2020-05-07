package com.gf.dp.factory;

public class ModernFactory implements AbstractFactory {

	@Override
	public Movable createMovable() {
		return new Car();
	}

	@Override
	public Food createFood() {
		return new Bread();
	}

	@Override
	public Weapon createWeapon() {
		return new Gun();
	}

}
