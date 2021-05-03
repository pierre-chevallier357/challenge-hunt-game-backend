package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

@RequiredArgsConstructor
@Getter
public class Arret {
	@Id
	@With
	private final int idArret;

	private final String nom;
	private final String code;
	private final float latitude;
	private final float longitude;
	private final String lienMap;
}
