package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Reponse {
	private final int question;
	private final String visite;
	private final String reponse;
}
