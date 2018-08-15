package br.com.trisoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Buffer generico onde o tipo é definido pelo parametro T
 * 
 * @author Luiz
 *
 */
public class Buffer<T> {

	private List<T> list = new ArrayList<>();

	public void adicionar(T elemento) {
		list.add(elemento);
	}

	public T remover() {
		T elemento = list.get(0);
		list.remove(0);
		return elemento;
	}

}
