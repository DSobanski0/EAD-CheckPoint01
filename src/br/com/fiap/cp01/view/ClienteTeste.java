package br.com.fiap.cp01.view;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.ClienteDao;
import br.com.fiap.cp01.dao.impl.ClienteDaoImpl;
import br.com.fiap.cp01.entity.Cliente;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;
import br.com.fiap.cp01.singleton.EntityManagerFactorySingleton;

public class ClienteTeste {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		Cliente cliente = new Cliente();
		
		// Cadastro
		try {
			clienteDao.inserir(cliente);
			clienteDao.commit();
			System.out.println("Cliente registrado");
		} catch ( CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		// Pesquisar e exibir
		try {
			cliente = clienteDao.consultar(1);
			System.out.println(cliente);
		} catch ( EntityNotFoundException e ) {
			System.out.println("Cliente não encontrado!");
		}
		
		// Atualizar
		cliente = new Cliente(1);
		try {
			clienteDao.atualizar(cliente);
			clienteDao.commit();
			System.out.println("Cliente atualizado");
		} catch ( CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		// Remover
		try {
			clienteDao.excluir(1);
			clienteDao.commit();
		} catch ( EntityNotFoundException | CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}