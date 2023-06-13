package org.java.demo.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Titolo della foto non può essere vuoto")
	private String titolo;
    private String descrizione;
    
    @NotBlank(message = "Url della foto non può essere vuoto")
    private String url;
    
    
    private boolean visibile;
    
//  @NotNull(message = "La lista delle categorie non può essere nulla")
    private List<String> categorie;
    
    public Foto() {}
    public Foto(String titolo, String descrizione, String url, boolean visibile, List<String> categorie) {
        setTitolo(titolo);
        setDescrizione(descrizione);
        setUrl(url);
        setVisibile(visibile);
        setCategorie(categorie);
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
    
    public List<String> getCategorie() {
        return categorie;
    }
    
    public void setCategorie(List<String> categorie) {
        this.categorie = categorie;
    }
    
	@Override
	public String toString() {
		return "(" + getId() + ") " + getTitolo()
				+ "\n" + getDescrizione() 
				+ "\n" + getUrl()
				+ "\n" + isVisibile();
	}
}

