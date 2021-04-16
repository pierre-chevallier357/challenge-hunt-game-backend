package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Visite {
	@Id
	@With
	private final String idVisite;

	private final String idDefi;
	private final int uid;
	private final Date dateVisite;
    private final int temps;
	private final int versionD;
    private final String modeD;
    private final String status;
    private final int note;
    private final int score;

}
