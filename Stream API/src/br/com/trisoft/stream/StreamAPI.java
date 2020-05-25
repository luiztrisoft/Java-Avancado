package br.com.trisoft.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.trisoft.domain.Produto;
import br.com.trisoft.domain.UnidadeMedida;

/**
 * 
 * @author Luiz
 *
 */
public class StreamAPI {
	
	/**
	 * Lista em ordem crescente os numeros entre 2 e 8 com cada elemento elevado ao quadrado
	 * Obs.: O encadeamento de operações é chamado de pipeline
	 */
	public void encadearOperações() {
		List<Integer> lista = Arrays.asList(1, 10, 8, 9, 6, 2);
		
		List<Integer> novaLista = lista.stream()
				.sorted()
				.filter(numero -> numero >= 2 && numero <= 8)
				.map(numero -> numero * numero)
				.collect(Collectors.toList());
		
		novaLista.forEach(numero -> System.out.println(numero));
	}
	
	public void getTodosProdutos() {
		List<Produto> produtos = getProdutos();		
		imprimir(produtos);
	}
	
	public void getProdutosVencidos() {
		List<Produto> produtos = getProdutos().stream()
				.filter(produto -> produto.getVencimento().isBefore(LocalDate.now()))
				.collect(Collectors.toList());		
		imprimir(produtos);
	}
	
	public void getProdutosEmDia() {
		List<Produto> produtos = getProdutos();
		produtos.removeIf(p -> p.getVencimento().isBefore(LocalDate.now()));
		imprimir(produtos);
	}
	
	public void getPromocaoItensAVencer(int percenturalDesconto) {
		List<Produto> produtos = getProdutos().stream()
				.filter(p ->p.getVencimento().isEqual(LocalDate.now()) 
						|| p.getVencimento().isAfter(LocalDate.now()) 
						&& p.getVencimento().isBefore(LocalDate.of(2020, 5,  30))
						&& p.getLote().equals("0002"))				
				.collect(Collectors.toList());
		
		//Map nao deixou inferir valores, entao usei o forEach
		int baseCalculo = 100 - percenturalDesconto >= 0 ? 100 - percenturalDesconto : 0;
		
		produtos.forEach(p -> p.setPreco((p.getPreco() * baseCalculo) / 100));
			
		imprimir(produtos);
	}
	
	
	private List<Produto> getProdutos (){
		
		int ano = LocalDate.now().getYear();
		int mesAtual = LocalDate.now().getMonthValue();
		int proximoMes = LocalDate.now().getMonthValue() == 12 ? 1 : LocalDate.now().getMonthValue() + 1;
		int dia = LocalDate.now().getDayOfMonth();
		
		Produto p001 = new Produto(1, "Arroz", 10.00, 5,UnidadeMedida.QUILO, 20, "0001", LocalDate.of(ano, mesAtual, dia + 1) );
		Produto p002 = new Produto(2, "Feijão", 7.00, 2, UnidadeMedida.QUILO, 20, "0001", LocalDate.of(ano, mesAtual, dia + 5));
		Produto p003 = new Produto(3, "Macarrão", 3.00, 500,UnidadeMedida.GRAMA, 20, "0001", LocalDate.of(ano, mesAtual, dia ) );
		Produto p004 = new Produto(4, "Sal", 8.00, 1,UnidadeMedida.QUILO, 20, "0001", LocalDate.of(ano, mesAtual, dia) );
		Produto p005 = new Produto(5, "Açucar", 8.00, 2,UnidadeMedida.QUILO, 20, "0001", LocalDate.of(ano, proximoMes, dia) );
		Produto p006 = new Produto(6, "Biscoito", 5.99, 120,UnidadeMedida.GRAMA, 20, "0001", LocalDate.of(ano, proximoMes, dia) );
		Produto p007 = new Produto(7, "Pão", 4.48, 450,UnidadeMedida.GRAMA, 30, "0001", LocalDate.of(ano-1, proximoMes , dia) );
		Produto p008 = new Produto(8, "Mortadela", 3.75, 1,UnidadeMedida.GRAMA, 20, "0001", LocalDate.of(ano-1, proximoMes, dia));
		Produto p009 = new Produto(9, "Mussarela", 7.00, 1,UnidadeMedida.QUILO, 20, "0001", LocalDate.of(ano-1, proximoMes, dia) );
		Produto p010 = new Produto(10, "Queijo", 15.00, 1,UnidadeMedida.QUILO, 20, "0001", LocalDate.of(ano-1, proximoMes, dia) );
		Produto p011 = new Produto(11, "Chocolate", 4.95, 90,UnidadeMedida.GRAMA, 20, "0001", LocalDate.of(ano, proximoMes, dia) );
		Produto p012 = new Produto(12, "Heineken", 4.39, 330,UnidadeMedida.ML, 20, "0001", LocalDate.of(ano, proximoMes, dia) );
		Produto p013 = new Produto(13, "Suco", 8.99, 900,UnidadeMedida.ML, 20, "0001", LocalDate.of(ano, proximoMes, dia) );
		Produto p014 = new Produto(14, "Arroz", 10.20, 5,UnidadeMedida.QUILO, 20, "0002", LocalDate.of(ano, proximoMes, dia) );
		Produto p015 = new Produto(15, "Feijão", 7.98, 2,UnidadeMedida.QUILO, 20, "0002", LocalDate.of(ano, proximoMes, dia) );
		Produto p016 = new Produto(16, "Coca-cola", 12.00, 2,UnidadeMedida.LITRO, 20, "0001", LocalDate.of(ano,proximoMes, dia) );
		Produto p017 = new Produto(17, "Coca-cola", 7.00, 1.5,UnidadeMedida.LITRO, 20, "0001", LocalDate.of(ano, proximoMes, dia) );
				
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(p001);
		produtos.add(p002);
		produtos.add(p003);
		produtos.add(p004);
		produtos.add(p005);
		produtos.add(p006);
		produtos.add(p007);
		produtos.add(p008);
		produtos.add(p009);
		produtos.add(p010);
		produtos.add(p011);
		produtos.add(p012);
		produtos.add(p013);
		produtos.add(p014);
		produtos.add(p015);
		produtos.add(p016);
		produtos.add(p017);
		
		return produtos;
	}
	
	private void imprimir(List<Produto> produtos) {
		produtos.forEach(p -> System.out.println(p));
		System.out.println();
		System.out.println("Total de produtos: " + produtos.size());
	}

}










