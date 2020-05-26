package br.com.trisoft;

import br.com.trisoft.stream.StreamAPI;

/*
 *Aproveita uso de expressões lambda
 *Funciona bem para coleções pequenas e também para as muito grandes
 *
 */
public class Main {
	public static void main(String[] args) {
		StreamAPI stream = new StreamAPI();
		//stream.encadearOperações();
		stream.optionalProduto();
	}

}
