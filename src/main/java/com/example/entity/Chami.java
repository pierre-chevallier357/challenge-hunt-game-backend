package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

@RequiredArgsConstructor
@Getter
public class Chami {
	@Id
	@With
	private final String uid;

	private final String email;
	private final String pseudo;
	private final int age;
	private final String ville;
	private final String description;
	private final int nbDefis;
}
