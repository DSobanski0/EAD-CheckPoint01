package br.com.fiap.cp01.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.ItemPedidoDao;
import br.com.fiap.cp01.entity.ItemPedido;

public class ItemPedidoDaoImpl extends GenericDaoImpl<ItemPedido, Integer> implements ItemPedidoDao {

	public ItemPedidoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}