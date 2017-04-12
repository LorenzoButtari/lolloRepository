package model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Curatore{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date datadinascita;
	@OneToMany(mappedBy="curatore")
	private List<Stanza> stanze;
	
	public Curatore(){
		this.stanze = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatadinascita() {
		return datadinascita;
	}

	public void setDatadinascita(Date datadinascita) {
		this.datadinascita = datadinascita;
	}

	public List<Stanza> getStanze() {
		return stanze;
	}

	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}

	public Long getId() {
		return id;
	}
	
	

}
