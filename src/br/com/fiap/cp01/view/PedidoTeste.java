package br.com.fiap.cp01.view;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.PedidoDao;
import br.com.fiap.cp01.dao.impl.PedidoDaoImpl;
import br.com.fiap.cp01.entity.Pedido;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;
import br.com.fiap.cp01.singleton.EntityManagerFactorySingleton;

public class PedidoTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PedidoDao pedidoDao = new PedidoDaoImpl(em);

		// Cadastrar
		Pedido pedido = new Pedido(20.50);
		try {
			pedidoDao.inserir(pedido);
			pedidoDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Exibir dados
		try {
			pedido = pedidoDao.consultar(1);
			System.out.println(pedido);
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Atualizar dados
		pedido = new Pedido(1, 50.35);
		try {
			pedidoDao.atualizar(pedido);
			pedidoDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Remover
		try {
			pedidoDao.excluir(1);
			pedidoDao.commit();
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}

		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}