package org.java.demo.pojo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Titolo della foto non può essere vuoto")
	private String titolo;
	
	@NotBlank
	@Size(min = 5, message = "La descrizione deve avere almeno 5 caratteri")
    private String descrizione;
    
    @NotBlank(message = "Url della foto non può essere vuoto")
    private String url;
    
    @NotNull(message = "Devi inserire un valore valido")
    private boolean visibile;
    
//    @NotNull(message = "La lista delle categorie non può essere nulla")
	@ManyToMany
    private List<Categoria> categorie;
    
    public Foto() {}
    public Foto(String titolo, String descrizione, String url, boolean visibile, Categoria... categoria) {
        setTitolo(titolo);
        setDescrizione(descrizione);
        setUrl(url);
        setVisibile(visibile);
        setCategorie(categoria);
    }
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    public String getTitolo() {
        return titolo;
    }
    
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public boolean isVisibile() {
        return visibile;
    }
    
    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }
    
    public List<Categoria> getCategorie() {
        return categorie;
    }
    
    @JsonSetter
	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	public void setCategorie(Categoria[] categorie) {
		
		setCategorie(Arrays.asList(categorie));
	}
	public void addCategoria(Categoria categoria) {
		
		getCategorie().add(categoria);
	}
	public void removeCategoria(Categoria categoria) {
		
		getCategorie().remove(categoria);
	}
    
	@Override
	public String toString() {
		return "(" + getId() + ") " + getTitolo()
				+ "\n" + getDescrizione() 
				+ "\n" + getUrl()
				+ "\n" + isVisibile();
	}
}

