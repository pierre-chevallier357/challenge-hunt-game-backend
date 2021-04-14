package com.example;

public class Chamis {
	private String login;
	private int age;
	private int nb_defis;

	public Chamis(String login, int age, int nb_defis) {
		this.login = login;
		this.age = age;
		this.nb_defis = nb_defis;
	}

	public int getNb_defis() {
		return this.nb_defis;
	}

	public void setNb_defis(int nb_defis) {
		this.nb_defis = nb_defis;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
