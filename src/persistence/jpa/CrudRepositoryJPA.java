package persistence.jpa;

import java.lang.reflect.*;
import java.util.List;
import javax.persistence.*;
import persistence.CrudRepository;

public class CrudRepositoryJPA<T> implements CrudRepository<T> {

	private EntityManager em;
	private Class<T> entityClass;
	
	public CrudRepositoryJPA(EntityManager em, Class<T> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
	}
	
	@Override
	public T save(T entity) {
		/**
		 * Da errore dato che non si sa se è presente il getId
		 * creo qundi una interface entity in cui inserisco il getId
		if(entity.getId() == null){
			em.persist(entity);
		}
		else{
			return em.merge(entity);
		}
		return entity;
	}*/
		/**
		 * Altra soluzione, ma anche qui andiamo a cercare un metodo di nome id
		 * dovremmo invece andare a cercare ciò che nell'entity è stato segnato proprio come @Id
		Method getId = null;
		T persistentEntity = null;
		getId = this.entityClass.getMethod("getId");	//mi faccio dare il metodo che si chiama getId.
		
		if(getId.invoke(entity) == null){				//invoco tale metodo.(so che esiste un metodo che si chiama cosi e lo invoco)
			em.persist(entity);							//Il metodo getId potrebbe comunque non esistere!Gli errori che ci da ci sono proprio perche dobbiamo gestire tale caso.
		}
		else{
			return em.merge(entity);
		}
		return entity;
	}*/
		Method getId = null;
		T persistentEntity = null;
		try{
			getId = this.entityClass.getMethod("getId");
		} catch (NoSuchMethodException | SecurityException e){
			e.printStackTrace();
		}
		try{		
			if(getId.invoke(entity) == null){
			em.persist(entity);
			persistentEntity = entity;
			}
			else{
				persistentEntity = em.merge(entity);
			}
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
			e.printStackTrace();
		}
		return persistentEntity;
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public List<T> findAll() {
		String fullClassName = this.entityClass.getCanonicalName();
		String className = fullClassName.substring(fullClassName.lastIndexOf('.')+1);
		TypedQuery<T> query = em.createQuery("SELECT e FROM " + fullClassName + " e", this.entityClass);
		return query.getResultList();
	}

	protected EntityManager getEm() {
		return em;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
		
	}

	@Override
	public void deleteAll() {
		String className = this.entityClass.getCanonicalName();
		Query query = em.createQuery("DELETE FROM" + className);
		query.executeUpdate();
	}

}
