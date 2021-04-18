package br.com.fiap.cp01.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.PedidoDao;
import br.com.fiap.cp01.entity.Pedido;

public class PedidoDaoImpl extends GenericDaoImpl<Pedido, Integer> implements PedidoDao {

	public PedidoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}