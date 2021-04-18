package br.com.fiap.cp01.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.PessoaDao;
import br.com.fiap.cp01.entity.Pessoa;

public class PessoaDaoImpl extends GenericDaoImpl<Pessoa, Integer> implements PessoaDao {

	public PessoaDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}