package persistence;

import model.*;
import java.util.*;

public interface OperaCrudRepository {

	public Opera save(Opera opera);
	public Opera findOne(Long id);
	public List<Opera> findAll();
	public void delete(Opera opera);
	
}
