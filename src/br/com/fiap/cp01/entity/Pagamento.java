package br.com.fiap.cp01.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PAGAMENTO")
@SequenceGenerator(name="pagamento", sequenceName="SQ_PAGAMENTO", allocationSize = 1)
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento")
	@Column(name="cd_pagamento")
	private int codigo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_pagamento", nullable = false)
	private TipoPagamento pagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_pagamento", updatable = false, nullable = false)
	private Calendar dataPagamento;
	
	@Column(name="vl_pagamento", nullable = false)
	private double valorPagamento;
	
	public Pagamento() {
		super();
	}

	public Pagamento(TipoPagamento pagamento, Calendar dataPagamento, double valorPagamento) {
		super();
		this.pagamento = pagamento;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
	}

	public Pagamento(int codigo, TipoPagamento pagamento, Calendar dataPagamento, double valorPagamento) {
		super();
		this.codigo = codigo;
		this.pagamento = pagamento;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(TipoPagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	@Override
	public String toString() {
		return "Pagamento [codigo = " + codigo + ", pagamento = " + pagamento + ", dataPagamento = " + dataPagamento.getTime()
				+ ", valorPagamento = R$" + valorPagamento + "]";
	}
}