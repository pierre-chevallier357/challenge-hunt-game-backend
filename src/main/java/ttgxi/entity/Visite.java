package ttgxi.entity;

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

	private final int idDefi;
	private final String uid;
	private final Date dateVisite;
    private final int temps;
	private final int versionD;
    private final String modeD;
    private final String status;
    private final int note;
    private final int score;
    private final String commentaire;

	private final Set<Reponse> reponses;

	public void addQuestion(Question question, String reponse, boolean indiceUtilise) {
		this.reponses.add(new Reponse(question.getIdQuestion(), reponse, indiceUtilise));
	}
}
