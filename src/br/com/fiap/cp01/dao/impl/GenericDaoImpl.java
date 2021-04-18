package br.com.fiap.cp01.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.cp01.dao.GenericDao;
import br.com.fiap.cp01.exception.CommitException;
import br.com.fiap.cp01.exception.EntityNotFoundException;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {

	private EntityManager em;

	private Class<E> clazz;

	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void inserir(E entidade) {
		em.persist(entidade);
	}

	@Override
	public E consultar(K id) throws EntityNotFoundException {
		E entidade = em.find(clazz, id);

		if (entidade == null) {
			throw new EntityNotFoundException();
		}
		
		return entidade;
	}

	@Override
	public void atualizar(E entidade) {
		em.merge(entidade);
	}

	@Override
	public void excluir(K id) throws EntityNotFoundException {
		E entidade = consultar(id);
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
			throw new CommitException();
		}
	}

}