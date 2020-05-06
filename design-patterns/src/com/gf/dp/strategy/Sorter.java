package com.gf.dp.strategy;

public class Sorter<T> {
	
	public static<T> void sort(T[] arr, Comparator<T> c) {
		for (int i=0; i<arr.length; i++) {
			int minIndex = i;
			for (int j=i+1; j<arr.length; j++) {
				if (c.compare(arr[j], arr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			
			swap(arr, i, minIndex);
		}
	}
	
	public static<T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
