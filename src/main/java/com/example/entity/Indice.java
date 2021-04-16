package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

@RequiredArgsConstructor
@Getter
public class Indice {
	@Id
	@With
	private final int idIndice;

	private final String idDefi;
	private final int numero;
	private final String description;
	private final int points;
}
