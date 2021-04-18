package br.com.fiap.cp01.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.FuncionarioDao;
import br.com.fiap.cp01.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.cp01.entity.Funcionario;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;
import br.com.fiap.cp01.singleton.EntityManagerFactorySingleton;

public class FuncionarioTeste {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		FuncionarioDao funcionarioDao = new FuncionarioDaoImpl(em);

		// Cadastrar
		Funcionario func = new Funcionario(255112, new GregorianCalendar(2011, Calendar.OCTOBER, 5));
		try {
			funcionarioDao.inserir(func);
			funcionarioDao.commit();
			System.out.println("Funcionario cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Exibir dados
		try {
			funcionarioDao.consultar(1);
			System.out.println(func);
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Atualizar
		func = new Funcionario(1, 82511, new GregorianCalendar(2015, Calendar.APRIL, 15));
		try {
			funcionarioDao.atualizar(func);
			funcionarioDao.commit();
			System.out.println("Funcionário cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// Remover
		try {
			funcionarioDao.excluir(1);
			funcionarioDao.commit();
			System.out.println("Funcionário deletado");
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}