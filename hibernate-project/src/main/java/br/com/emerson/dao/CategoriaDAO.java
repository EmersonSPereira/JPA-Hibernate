package br.com.emerson.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.emerson.conection.ConectionFactory;
import br.com.emerson.model.Categoria;

public class CategoriaDAO {

	public Categoria salvar(Categoria categoria) {

		EntityManager em = new ConectionFactory().getConection();

		try {
			em.getTransaction().begin();
			
			//verifica se o objeto já existe na tabela
			if(categoria.getId() == null) {
				//se não existir o objeto é criado na tabela
				em.persist(categoria);

			}else {
				//caso exista o objeto é alterado
				em.merge(categoria);
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return categoria;

	}
	
	//Buscando no banco pelo id
	public Categoria findByid(Integer id) {
		
		EntityManager em = new ConectionFactory().getConection();
		Categoria categoria = null;
		
		try {
			
			categoria = em.find(Categoria.class, id);
		
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
			
		}
		
		return categoria;

		
		
	}
	
	//Buscando todos os itens de uma tabela
	public List<Categoria> findAll(){
		
		EntityManager em = new ConectionFactory().getConection();
		List<Categoria> categorias = null;
		
		try {
			
			categorias = em.createQuery("from Categoria").getResultList();
			
		} catch (Exception e) {
			
			System.err.println(e);
			// TODO: handle exception
		} finally {
			em.close();
		}
		
		return categorias;

		
	}
	
	public Categoria remove(Integer id) {
		
		EntityManager em = new ConectionFactory().getConection();
		Categoria categoria = null;

		
		try {
			categoria = em.find(Categoria.class, id);
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
		return categoria;
	}

}
