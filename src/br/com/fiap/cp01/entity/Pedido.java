package br.com.fiap.cp01.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_PEDIDO")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_PEDIDO", allocationSize = 1)
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	@Column(name = "cd_pedido")
	private int codigo;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "dt_pedido", updatable = false)
	private Calendar dataPedido;

	@Column(name = "vl_pedido_total", nullable = false)
	private double valorTotal;

	public Pedido() {
		super();
	}

	public Pedido(double valorTotal) {
		super();
		this.valorTotal = valorTotal;
	}

	public Pedido(int codigo, double valorTotal) {
		super();
		this.codigo = codigo;
		this.valorTotal = valorTotal;
	}

	public Pedido(Calendar dataPedido, double valorTotal) {
		super();
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Pedido [codigo = " + codigo + ", dataPedido = " + dataPedido.getTime() + ", valorTotal = R$" + valorTotal + "]";
	}
}