package br.com.emerson.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.emerson.conection.ConectionFactory;
import br.com.emerson.model.Produto;

public class ProdutoDAO {

	public Produto save(Produto produto) {

		EntityManager em = new ConectionFactory().getConection();

		try {
			em.getTransaction().begin();
			if (produto.getId() == null) {
				em.persist(produto);

			} else {
				em.merge(produto);
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return produto;

	}

	public Produto findById(Integer id) {

		EntityManager em = new ConectionFactory().getConection();
		Produto produto = null;

		try {
			produto = em.find(Produto.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		} finally {

			em.close();
		}

		return produto;

	}

	public List<Produto> findAll() {
		EntityManager em = new ConectionFactory().getConection();
		List<Produto> produtos = null;

		try {

			produtos = em.createQuery("from Produto ").getResultList();

		} catch (Exception e) {
			System.err.println(e);

		} finally {

			em.close();
		}

		return produtos;

	}

	public Produto remove(Integer id) {

		EntityManager em = new ConectionFactory().getConection();
		Produto produto = null;

		try {
			produto = em.find(Produto.class, id);
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		
		return produto;
	}

}
