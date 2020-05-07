package com.gf.dp.factory;

public class MagicFactory implements AbstractFactory {

	@Override
	public Movable createMovable() {
		return new Broom();
	}

	@Override
	public Food createFood() {
		return new Mushroom();
	}

	@Override
	public Weapon createWeapon() {
		return new MagicStick();
	}

}
