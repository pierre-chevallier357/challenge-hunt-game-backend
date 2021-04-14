package com.example;

public class Defi {
	private String id;
	private String titre;
	private String datedecreation;
	private String description;
	private String auteur;

	public Defi(String id, String titre, String datedecreation, String description, String auteur) {
		this.id = id;
		this.titre = titre;
		this.datedecreation = datedecreation;
		this.description = description;
		this.auteur = auteur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDatedecreation() {
		return datedecreation;
	}

	public void setDatedecreation(String datecreation) {
		this.datedecreation = datecreation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
