package br.com.emerson.conection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionFactory {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
	
	
	public EntityManager getConection() {
		
		return emf.createEntityManager();
	}

}
