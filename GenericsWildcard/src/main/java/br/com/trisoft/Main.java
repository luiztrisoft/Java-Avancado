package br.com.trisoft;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Bebida> bebidas = new ArrayList<>();

		bebidas.add(new Cafe());
		bebidas.add(new Cha());

		prepararBebidas(bebidas);

		List<Cha> chas = new ArrayList<>();
		chas.add(new Cha());
		prepararBebidas(chas);// Permitido por causa do wildcard

		List<Cafe> cafes = new ArrayList<>();
		cafes.add(new Cafe());
		prepararBebidas(cafes);// Permitido por causa do wildcard

		prepararBebidas2(chas);
		prepararBebidas3(bebidas);
	}

	/**
	 * Com o wildcard ? extendendo de Bebida nos permite adicionar uma lista de chas
	 * e cafés pois ambos implementam Bebida. Note que mesmo sendo uma interface nós
	 * usamos extends quando usamos wildcards.
	 * 
	 * Dentro do método não podemos criar a instrução bebidas.add(new Cha()) pois
	 * não é seguro tal código pois poderíamos adicionar qualquer tipo de objeto
	 * 
	 * @param bebidas
	 */
	private static void prepararBebidas(List<? extends Bebida> bebidas) {
		// bebidas.add(new Cha());
		for (Bebida b : bebidas) {
			b.preparar();
		}
	}

	/**
	 * Este método nos permite adicionar uma lista de chás e qualquer superclasse ao
	 * qual ele pertença(Bebida). Claro que um Object também pode ser adicionado. O
	 * efeito colateral é a necessidade de fazer cast dos elementos.
	 * 
	 * Dentro do método podemos criar a instrução bebidas.add(new Cha()) pois o tipo
	 * Cha será garantido diferente do método anterior.
	 * 
	 * @param bebidas
	 */
	private static void prepararBebidas2(List<? super Cha> bebidas) {
		bebidas.add(new Cha());
		for (Object obj : bebidas) {
			Cha cha = (Cha) obj;
			cha.preparar();
		}
	}

	/**
	 * Podemos informar qualquer tipo mas podemos ter problemas no cast. Imaginando
	 * que o elemento seja do tipo Cha como no exemplo a instrução ocorrerá
	 * normalmente. Mas se adicionarmos o tipo Cafe na lista e invocarmos o método
	 * ele terá um erro pois Cafe não passará no cast.
	 * 
	 * Um tratamento para isso seria fazer uma verificação através do instanceof.
	 * 
	 * @param bebidas
	 */
	private static void prepararBebidas3(List<?> bebidas) {
		for (Object obj : bebidas) {
			Cha cha = (Cha) obj;
			cha.preparar();
		}
	}

}
