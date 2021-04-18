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
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SQ_CLIENTE", allocationSize = 1)
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	@Column(name="cd_cliente")
	private int codigo;
	
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name="dt_cadastro", updatable = false)
	private Calendar dataCadastro;

	public Cliente() {
		super();
	}

	public Cliente(int codigo) {
		super();
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Cliente [codigo = " + codigo + ", dataCadastro = " + dataCadastro.getTime() + "]";
	}
}