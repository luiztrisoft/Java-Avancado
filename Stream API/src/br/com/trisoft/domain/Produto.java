package br.com.trisoft.domain;
import java.time.LocalDate;

public class Produto {	
	private long id;
	private String descricao;
	private double preco;
	private String lote;
	private LocalDate vencimento;
	private double medida;
	private UnidadeMedida unidadeMedida;
	private int quantidade;
	
	public Produto(long id, String descricao, Double preco, double medida,UnidadeMedida unidadeMedida, 
			int quantidade, String lote, LocalDate vencimento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.lote = lote;
		this.vencimento = vencimento;
		this.medida = medida;
		this.unidadeMedida = unidadeMedida;
		this.quantidade = quantidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public double getMedida() {
		return medida;
	}

	public void setMedida(double medida) {
		this.medida = medida;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString() {
		return "\n[PRODUTO " + id + "]\nDescricao: " + descricao
				+ "\nPreço: R$" + preco
				+ "\nPeso: " + medida + " " + unidadeMedida
				+ "\nVencimento: " + vencimento.getDayOfMonth() + "/" + vencimento.getMonthValue() + "/" + vencimento.getYear();
				
	}

}