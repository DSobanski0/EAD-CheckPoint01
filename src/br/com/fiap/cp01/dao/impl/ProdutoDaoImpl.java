package br.com.fiap.cp01.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.ProdutoDao;
import br.com.fiap.cp01.entity.Produto;

public class ProdutoDaoImpl extends GenericDaoImpl<Produto, Integer> implements ProdutoDao{

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}