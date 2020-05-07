package com.gf.dp.decorator;

public class HaDecorator extends Decorator {

	public HaDecorator(Printer printer) {
		super(printer);
	}

	@Override
	public void print() {
		System.out.println("ha...................");
		printer.print();
	}

}
