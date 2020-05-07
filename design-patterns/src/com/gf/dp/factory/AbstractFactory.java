package com.gf.dp.factory;

public interface AbstractFactory {
	
	Movable createMovable();
	
	Food createFood();
	
	Weapon createWeapon();

}
