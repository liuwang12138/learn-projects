package com.gf.dp.strategy;

public class StrategyMain {
	
	public static void main(String[] args) {
		
		Cat[] arr = {new Cat(2, 5), new Cat(5, 2), new Cat(4, 3), new Cat(3, 1), new Cat(1, 4)};
		
		Sorter.sort(arr, new CatWeightComparator());
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
