package br.com.fiap.cp01.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.PagamentoDao;
import br.com.fiap.cp01.dao.impl.PagamentoDaoImpl;
import br.com.fiap.cp01.entity.Pagamento;
import br.com.fiap.cp01.entity.TipoPagamento;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;
import br.com.fiap.cp01.singleton.EntityManagerFactorySingleton;

public class PagamentoTeste {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		PagamentoDao pgmtDao = new PagamentoDaoImpl(em);
		
		// Cadastrar
		Pagamento pagamento = new Pagamento(TipoPagamento.DINHEIRO, new GregorianCalendar(2021, Calendar.APRIL, 16), 50.30);
		try {
			pgmtDao.inserir(pagamento);
			pgmtDao.commit();
			System.out.println("Pagamento cadastrado");
		} catch ( CommitException e ) {
			System.out.println(e.getMessage());
		}
			
		// Exibir dados
		try {
			pagamento = pgmtDao.consultar(1);
			System.out.println(pagamento);
		} catch ( EntityNotFoundException e ) {
			System.out.println(e.getMessage());
		}
		
		// Atualizar
		pagamento = new Pagamento(1, TipoPagamento.BOLETO, new GregorianCalendar(2021, Calendar.MARCH, 5), 50.30);
		try {
			pgmtDao.atualizar(pagamento);
			pgmtDao.commit();
		} catch ( CommitException e ) {
			System.out.println(e.getMessage());
		}
		
		// Remover
		try {
			pgmtDao.excluir(1);
			pgmtDao.commit();
		} catch ( EntityNotFoundException | CommitException e ){
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}