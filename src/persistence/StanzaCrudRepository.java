package persistence;

import java.util.List;

import model.Stanza;

public interface StanzaCrudRepository {

	public Stanza save(Stanza stanza); //per fare la persist di un nuovo elemento
	public Stanza findOne(Long id); //per prendere un oggetto...
	public List<Stanza> findAll(); //o tutti gli oggetti!
	public void delete(Stanza artista); //per l'eliminzaione di un oggetto
	public void deleteAll();
}
