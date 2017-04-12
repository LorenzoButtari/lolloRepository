package model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Opera{
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private String titolo;
	 @Temporal(TemporalType.DATE)
	 private Date anno;
	 @ManyToMany(mappedBy="opere")
	 private List<Artista> artisti;
	 
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Date getAnno() {
		return anno;
	}
	
	public void setAnno(Date anno) {
		this.anno = anno;
	}
	
	public List<Artista> getArtisti() {
		return artisti;
	}
	
	public void setArtisti(List<Artista> artisti) {
		this.artisti = artisti;
	}
	
	public Long getId() {
		return id;
	}
}
