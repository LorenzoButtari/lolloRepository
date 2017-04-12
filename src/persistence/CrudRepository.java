package persistence;

import java.util.List;

/**
 * Interfaccia da usare ogni volta senza che ogni volta
 * facciamo copia incolla da interface a interface
 * */
public interface CrudRepository<T> {

	public T save(T entity);
	public T findOne(Long id);
	public List<T> findAll();
	public void delete(T entity);
	public void deleteAll();
}
