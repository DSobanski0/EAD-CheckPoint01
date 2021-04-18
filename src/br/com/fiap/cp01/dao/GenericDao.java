package br.com.fiap.cp01.dao;

import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;

public interface GenericDao<E, K> {
	
	void inserir(E entidade);
	
	E consultar(K id) throws EntityNotFoundException;

	void atualizar(E entidade);
	
	void excluir(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
	
}