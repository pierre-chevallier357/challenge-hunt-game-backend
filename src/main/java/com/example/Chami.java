package com.example;

import org.springframework.data.annotation.Id;

public class Chami {
	@Id
	private final int uid;

	private final String email;
	private final String pseudo;
	private final int age;
	private final String ville;
	private final String description;
	private final int nbDefis;

	public Chami(int uid, String email, String pseudo, int age, String ville, String description, int nbDefis) {
		this.uid = uid;
		this.email = email;
		this.pseudo = pseudo;
		this.age = age;
		this.ville = ville;
		this.description = description;
		this.nbDefis = nbDefis;
	}

	public Chami withUid(int uid) {
		return new Chami(uid, email, pseudo, age, ville, description, nbDefis);
	}

	public int getUid() {
		return uid;
	}

	public String getEmail() {
		return email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public int getAge() {
		return age;
	}

	public String getVille() {
		return ville;
	}

	public String getDescription() {
		return description;
	}

	public int getNbDefis() {
		return nbDefis;
	}
}
