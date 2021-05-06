package ttgxi.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Reponse {
	private final int question;
	private final String reponse;
	private final boolean indiceUtilise;
}
