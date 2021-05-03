package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Visite {
	@Id
	@With
	private final int idVisite;

	private final String idDefi;
	private final int uid;
	private final Date dateVisite;
    private final int temps;
	private final int versionD;
    private final String modeD;
    private final String status;
    private final int note;
    private final int score;
    private final String commentaire;

	private final Set<IndiceUtilise> indices;
	private final Set<Reponse> reponses;

	public void addIndice(Indice indice) {
		indices.add(new IndiceUtilise(indice.getIdIndice()));
	}

	public void addQuestion(Question question, String reponse) {
		this.reponses.add(new Reponse(question.getIdQuestion(), reponse));
	}
}
