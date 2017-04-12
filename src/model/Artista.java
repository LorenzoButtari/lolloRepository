package model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Artista{
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private String nome;
	 @ManyToMany
	 private List<Opera> opere;
	 
	 public Artista(){
		 this.opere = new ArrayList<>();
	 }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString(){
		return this.nome;
	}
}
