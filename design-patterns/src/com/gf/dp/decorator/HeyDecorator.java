package com.gf.dp.decorator;

public class HeyDecorator extends Decorator {

	public HeyDecorator(Printer printer) {
		super(printer);
	}

	@Override
	public void print() {
		System.out.println("hey...................");
		printer.print();
	}
	
	

}
