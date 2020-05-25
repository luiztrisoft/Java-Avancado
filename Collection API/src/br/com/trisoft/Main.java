package br.com.trisoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		//List<Integer> list = Arrays.asList(4,5,7,2,1,6,0,3);
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(1);
		list.add(6);
		list.add(3);
		
		list.sort((x, y)-> -x.compareTo(y));
		//list.replaceAll(e -> e * 2);
		list.removeIf(e -> e % 2 != 0);
		list.forEach(e -> System.out.println(e));
	}
}
