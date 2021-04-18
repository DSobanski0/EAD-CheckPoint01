package br.com.fiap.cp01.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.PessoaDao;
import br.com.fiap.cp01.dao.impl.PessoaDaoImpl;
import br.com.fiap.cp01.entity.Pessoa;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;
import br.com.fiap.cp01.singleton.EntityManagerFactorySingleton;

public class PessoaTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PessoaDao pessoaDao = new PessoaDaoImpl(em);

		// Cadastrar
		Pessoa pessoa = new Pessoa("João", 1190500, 154785215, 99624541, "joao@hotmail.com",
				new GregorianCalendar(2005, Calendar.AUGUST, 14));
		try {
			pessoaDao.inserir(pessoa);
			pessoaDao.commit();
			System.out.println("Pessoa cadastrada");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Exibir dados
		try {
			pessoa = pessoaDao.consultar(1);
			System.out.println(pessoa);
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		// Atualizar
		pessoa = new Pessoa(1, "Guilherme", 1190551, 154785215, 98541256, "guilherme@hotmail.com",
				new GregorianCalendar(2005, Calendar.AUGUST, 14));
		try {
			pessoaDao.atualizar(pessoa);
			pessoaDao.commit();
			System.out.println("Pessoa atualizada");
		} catch ( CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		// Remover
		try {
			pessoaDao.excluir(1);
			pessoaDao.commit();
			System.out.println("Pessoa removida");
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}