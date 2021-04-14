package com.example;

import org.springframework.data.annotation.Id;

public class Chamis {
	@Id
	private final String login;

	private final int age;
	private final int nbDefis;

	public Chamis(String login, int age, int nbDefis) {
		this.login = login;
		this.age = age;
		this.nbDefis = nbDefis;
	}

	public Chamis withLogin(String login) {
		return new Chamis(login, age, nbDefis);
	}

	public String getLogin() {
		return login;
	}

	public int getAge() {
		return age;
	}

	public int getNbDefis() {
		return nbDefis;
	}
}
