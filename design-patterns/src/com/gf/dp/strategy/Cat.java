package com.gf.dp.strategy;

public class Cat {
	
	int height;
	
	int weight;
	
	public Cat(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cat [height=" + height + ", weight=" + weight + "]";
	}

}
