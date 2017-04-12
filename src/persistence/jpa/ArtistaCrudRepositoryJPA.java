package persistence.jpa;

import java.util.*;
import javax.persistence.*;
import model.*;
import persistence.ArtistaCrudRepository;

public class ArtistaCrudRepositoryJPA implements ArtistaCrudRepository{
	private EntityManager em;
	private EntityTransaction tx;

	public ArtistaCrudRepositoryJPA(EntityManager em) {
		this.em = em;
		this.tx = em.getTransaction();
	}
	/**
	 * Se vogliamo che la transazine renda persistenti piu cose l'em deve essere unico!
	 * */
	@Override
	public Artista save(Artista artista) {
		if(artista.getId() == null){
			em.persist(artista);
		}
		else{
			//em.merge(artista); aggiorna il database con i dati di artista ma mantiene l'entità nello stato
			//in cui era prima,merge deve ritornare una copia dell'oggetto che deve essere managed!!
			return em.merge(artista); //cosi l'oggetto che mi ritorna il save è un oggetto managed
		}
		return artista;
	}

	@Override
	public Artista findOne(Long id) {
		return em.find(Artista.class, id); //find vuole la classe dell'entita e l'id
	}

	@Override
	public List<Artista> findAll() {
		Query query = em.createQuery("SELECT a FROM Artista a");
		return query.getResultList();
	}

	@Override
	public void delete(Artista artista) {
		em.remove(artista);		
	}
	
	@Override
	public void deleteAll() {
		Query query = em.createQuery("DELETE a FROM Artista a");
		query.executeUpdate();
	}

}
