package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Defi {
	@Id
	@With
	private final String idDefi;

	private final int uid;
	private final String titre;
	private final DefiType defiType;
	private final Date dateCreation;
	private final Date dateModification;
	private final int versionD;
	private final String motsClefs;
	private final int points;
	private final int duree;
	private final String prologue;
	private final String description;
	private final String epilogue;
	private final String commentaire;
}
