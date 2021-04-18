package br.com.fiap.cp01.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.PagamentoDao;
import br.com.fiap.cp01.entity.Pagamento;

public class PagamentoDaoImpl extends GenericDaoImpl<Pagamento, Integer> implements PagamentoDao {

	public PagamentoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}