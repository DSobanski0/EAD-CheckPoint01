package br.com.fiap.cp01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "produto", sequenceName = "SQ_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	@Column(name = "cd_produto")
	private int codigo;

	@Column(name = "nm_produto", length = 50, nullable = false)
	private String nomeProduto;

	@Column(name = "nr_quantidade_estoque", nullable = false)
	private int qntEstoque;

	@Column(name = "vl_venda", nullable = false)
	private double valorVenda;

	public Produto() {
		super();
	}

	public Produto(String nomeProduto, int qntEstoque, double valorVenda) {
		super();
		this.nomeProduto = nomeProduto;
		this.qntEstoque = qntEstoque;
		this.valorVenda = valorVenda;
	}

	public Produto(int codigo, String nomeProduto, int qntEstoque, double valorVenda) {
		super();
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.qntEstoque = qntEstoque;
		this.valorVenda = valorVenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQntEstoque() {
		return qntEstoque;
	}

	public void setQntEstoque(int qntEstoque) {
		this.qntEstoque = qntEstoque;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public String toString() {
		return "Produto [codigo = " + codigo + ", nomeProduto = " + nomeProduto + ", qntEstoque = " + qntEstoque
				+ ", valorVenda = R$" + valorVenda + "]";
	}
}