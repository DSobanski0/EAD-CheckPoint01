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

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName ="SQ_FUNCIONARIO", allocationSize = 1)
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="funcionario")
	@Column(name="cd_funcionario")
	private int codigo;
	
	@Column(name="nr_ctps", nullable = false)
	private Integer ctps;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_contratacao", updatable = false, nullable = false)
	private Calendar dataContratacao;
	
	public Funcionario() {
		super();
	}

	public Funcionario(Integer ctps, Calendar dataContratacao) {
		super();
		this.ctps = ctps;
		this.dataContratacao = dataContratacao;
	}

	public Funcionario(int codigo, Integer ctps, Calendar dataContratacao) {
		super();
		this.codigo = codigo;
		this.ctps = ctps;
		this.dataContratacao = dataContratacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Integer getCtps() {
		return ctps;
	}

	public void setCtps(Integer ctps) {
		this.ctps = ctps;
	}

	public Calendar getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Calendar dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo = " + codigo + ", ctps = " + ctps + ", dataContratacao = " + dataContratacao.getTime() + "]";
	}
}