package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import persistence.ArtistaCrudRepository;
import persistence.CrudRepository;
import persistence.jpa.ArtistaCrudRepositoryJPA;
import persistence.jpa.CrudRepositoryJPA;

public class MainMuseo{
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("museo-unit");
		EntityManager em = emf.createEntityManager();
		
		Artista a = new Artista();
		a.setNome("pablo");
		
		Stanza s = new Stanza();
		s.setNome("N11");
		
		CrudRepository<Artista> artistaRepository = new CrudRepositoryJPA<Artista>(em, Artista.class);
		CrudRepository<Stanza> stanzaRepository = new CrudRepositoryJPA<Stanza>(em, Stanza.class);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		artistaRepository.save(a);
		List<Artista> artisti = artistaRepository.findAll();
		for(Artista artista : artisti){
			System.out.println(artista.toString());
		}
		
		stanzaRepository.save(s);
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}