package br.com.fiap.cp01.view;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.ItemPedidoDao;
import br.com.fiap.cp01.dao.impl.ItemPedidoDaoImpl;
import br.com.fiap.cp01.entity.ItemPedido;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;
import br.com.fiap.cp01.singleton.EntityManagerFactorySingleton;

public class ItemPedidoTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ItemPedidoDao itemPedidoDao = new ItemPedidoDaoImpl(em);
		
		// Cadastro
		ItemPedido itemPedido = new ItemPedido(20, 15.50);
		try {
			itemPedidoDao.inserir(itemPedido);
			itemPedidoDao.commit();
			System.out.println("Item Pedido Cadastrado");
		} catch ( CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		// Exibir dados
		try {
			itemPedido = itemPedidoDao.consultar(1);
			System.out.println(itemPedido);
		} catch ( EntityNotFoundException e ) {
			System.out.println(e.getMessage());
		}
		
		// Atualizar dados
		itemPedido = new ItemPedido(1, 10, 15.50);
		try {
			itemPedidoDao.atualizar(itemPedido);
			itemPedidoDao.commit();
		} catch ( CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		// Remover dados
		try {
			itemPedidoDao.excluir(1);
			itemPedidoDao.commit();
		} catch (EntityNotFoundException | CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}