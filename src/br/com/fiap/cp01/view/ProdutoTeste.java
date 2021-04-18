package br.com.fiap.cp01.view;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.ProdutoDao;
import br.com.fiap.cp01.dao.impl.ProdutoDaoImpl;
import br.com.fiap.cp01.entity.Produto;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;
import br.com.fiap.cp01.singleton.EntityManagerFactorySingleton;

public class ProdutoTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ProdutoDao produtoDao = new ProdutoDaoImpl(em);

		// Cadastrar
		Produto produto = new Produto("Caneta", 500, 1.50);
		try {
			produtoDao.inserir(produto);
			produtoDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Exibir dados
		try {
			produto = produtoDao.consultar(1);
			System.out.println(produto);
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Atualizar
		produto = new Produto(1, "Lápis", 150, 0.50);
		try {
			produtoDao.atualizar(produto);
			produtoDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Remover
		try {
			produtoDao.excluir(1);
			produtoDao.commit();
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
	}
}