package ttgxi.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

@RequiredArgsConstructor
@Getter
public class Question {
	@Id
	@With
	private final int idQuestion;

	private final int idDefi;
	private final int numero;
	private final String question;
    private final String secret;
	private final int pointsQuestion;
	private final String indice;
	private final int pointsIndice;
}
