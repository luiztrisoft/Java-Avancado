package br.com.trisoft;

/**
 * 
 * @author Luiz
 *
 */
public class Main {

	public static void main(String[] args) {

		Buffer<String> b = new Buffer<>();
		
		b.adicionar("a");
		b.adicionar("b");
		b.adicionar("c");
		
		String e1 = b.remover();
		String e2 = b.remover();
		String e3 = b.remover();
		
		System.out.println(e1 + ", " + e2 + ", " + e3);
		
		//Segundo buffer do tipo Integer sem mexer no meu Buffer
		
		Buffer<Integer> b2 = new Buffer<>();

		b2.adicionar(10);
		b2.adicionar(20);
		b2.adicionar(30);

		Integer e4 = b2.remover();
		Integer e5 = b2.remover();
		Integer e6 = b2.remover();

		System.out.println(e4 + ", " + e5 + ", " + e6);
	}

}
