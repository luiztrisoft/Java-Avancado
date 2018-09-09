package br.com.trisoft;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Os métodos equals e hashcode permitem a busca rápida em coleções do tipo
 * hash. Também são importantes na identificação de um objeto.
 * 
 * Sem a sobrescrita de equals(), o método contains() da lista irá retornar true
 * apenas quando for o mesmo objeto, a mesma instancia. Isso quer dizer que ao
 * cadastrar dois produtos com mesmo sku, o programa permitiria pois o equals
 * não está sobrescrito e as instancias do objeto são diferentes. A sobrescrita
 * de equals() ensina a classe Produto a comprar dois objetos através do sku.
 * 
 * Usando ArrayList o método contains() funciona corretamente. Mas se nossa
 * coleção for um HashSet como no exemplo, o contains() retorna false mesmo con
 * skus iguais. O hashCode() é importante para determinar em que espaço o objeto
 * ficará dentro de uma coleção onde estes objetos ficam agrupados por
 * semelhança. Seria como uma lista telefonica onde você encontrará o Jose da
 * Silva dentro da letra J. Ao reescrever o método hashCode(), ele retornará o
 * inteiro que representa o "código da lista telefonica que ele ficará".
 * 
 * Obs.: A geração automática do eclipse já nos garante que os objetos fiquem em
 * espaços balanceados. Por exemplo, na lista telefonica usada como exemplo,
 * José da Silva ficará no J, que contém muito mais nomes que na letra Z. Esse
 * desbaleanceamento não é eficiente computacionalmente falando.
 * 
 * @author Luiz
 */
public class Main {

	public static void main(String[] args) {

		Collection<Produto> produtos = new HashSet<>();

		System.out.println("#### Cadastro de produtos ####\n");

		try (Scanner entrada = new Scanner(System.in)) {

			String continuar = "s";

			while ("s".equalsIgnoreCase(continuar)) {
				System.out.println("SKU: ");
				String sku = entrada.nextLine();

				System.out.println("Nome: ");
				String nome = entrada.nextLine();

				Produto produto = new Produto(sku, nome);

				if (produtos.contains(produto)) {
					System.out.println("Este produto já foi adicionado, Utilize outro SKU!");
					System.err.flush();
				} else {
					produtos.add(produto);
					System.out.println("Produto adicionado.");
				}

				System.out.println("\nDeseja adicionar mais algum produto? (s/n)");
				continuar = entrada.nextLine();
			}

			produtos.forEach(System.out::println);
			System.out.println("Fim");

		}

	}

}
