package br.com.fiap.cp01.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.FuncionarioDao;
import br.com.fiap.cp01.entity.Funcionario;

public class FuncionarioDaoImpl extends GenericDaoImpl<Funcionario, Integer> implements FuncionarioDao {

	public FuncionarioDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}