package org.java.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Nome della categoria non può essere vuoto")
	private String nome;
    
    public Categoria() {}
    public Categoria(String nome) {
        setNome(nome);
    }

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
	@Override
	public String toString() {
		return "(" + getId() + ") " + getNome();
	}
}
