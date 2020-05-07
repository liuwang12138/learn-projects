package com.gf.dp.decorator;

public class Main {
	
	public static void main(String[] args) {
		new HaDecorator(new HeyDecorator(new HelloPrinter())).print();
	}

}
