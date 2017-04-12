package persistence;

import model.*;
import java.util.*;

public interface ArtistaCrudRepository {

	public Artista save(Artista artista); //per fare la persist di un nuovo elemento
	public Artista findOne(Long id); //per prendere un oggetto...
	public List<Artista> findAll(); //o tutti gli oggetti!
	public void delete(Artista artista); //per l'eliminzaione di un oggetto
	public void deleteAll();
}
