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
@Table(name="TB_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName ="SQ_PESSOA", allocationSize = 1)
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa")
	@Column(name="cd_pessoa")
	private int codigo;
	
	@Column(name="nm_pessoa", length = 60, nullable = false)
	private String nome;
	
	@Column(name="nr_cep", nullable = false)
	private long cep;
	
	@Column(name="nr_cpf", nullable = false)
	private long cpf;
	
	@Column(name="nr_telefone")
	private Integer telefone;
	
	@Column(name="ds_email", length = 50)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento", nullable = false, updatable = false)
	private Calendar dataNascimento;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, long cep, long cpf, Integer telefone, String email,
			Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.cep = cep;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Pessoa(int codigo, String nome, long cep, long cpf, Integer telefone, String email,
			Calendar dataNascimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cep = cep;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo = " + codigo + ", nome = " + nome + ", cep = " + cep + ", cpf = " + cpf + ", telefone = "
				+ telefone + ", email = " + email + ", dataNascimento = " + dataNascimento.getTime() + "]";
	}
}