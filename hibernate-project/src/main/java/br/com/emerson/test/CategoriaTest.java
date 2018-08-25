package br.com.emerson.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.emerson.conection.ConectionFactory;
import br.com.emerson.dao.CategoriaDAO;
import br.com.emerson.model.Categoria;

public class CategoriaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CategoriaDAO dao = new CategoriaDAO();
		Categoria c = new Categoria();
		c.setDescricao("Bebida");

		
		dao.salvar(c);

	}

}
