package br.com.fiap.cp01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ITEM_PEDIDO")
@SequenceGenerator(name="itemPedido", sequenceName = "SQ_ITEM_PEDIDO", allocationSize = 1)
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemPedido")
	@Column(name="cd_item_pedido")
	private int codigo;
	
	@Column(name="qt_item_pedido", nullable = false)
	private int quantidade;
	
	@Column(name="vl_unitario", nullable = false)
	private double valorUnitario;
	
	@Column(name="vl_total_item", nullable = false)
	private double valorTotalItem;
	
	public ItemPedido() {
		super();
	}

	public ItemPedido(int quantidade, double valorUnitario) {
		super();
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotalItem = quantidade * valorUnitario;
	}

	public ItemPedido(int codigo, int quantidade, double valorUnitario) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotalItem = quantidade * valorUnitario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotalItem() {
		return valorTotalItem;
	}

	public void setValorTotalItem(double valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}

	@Override
	public String toString() {
		return "ItemPedido [codigo = " + codigo + ", quantidade = " + quantidade + ", valorUnitario = R$" + valorUnitario
				+ ", valorTotalItem = R$" + valorTotalItem + "]";
	}
}