package ru.vsu.cs;

import ru.vsu.cs.io.resource.EnglishStringResources;
import ru.vsu.cs.io.resource.StringResource;
import ru.vsu.cs.service.AnimalGuesserGameService;


public class AnimalGuesserApplication {

	public static void main(String[] args) {
		StringResource gameLanguageStringResource = new EnglishStringResources();

		AnimalGuesserGameService game = new AnimalGuesserGameService(gameLanguageStringResource);
		game.invokeService();
	}
}
