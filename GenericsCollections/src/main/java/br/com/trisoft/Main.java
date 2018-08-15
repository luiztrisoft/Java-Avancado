package br.com.trisoft;

import java.util.ArrayList;
import java.util.List;

/**
 * List de Strings
 * 
 * @author Luiz
 *
 */
public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("abc");
		list.add("def");
		list.add("ghi");

		for (String s : list) {
			System.out.println(s);
		}
	}
}
