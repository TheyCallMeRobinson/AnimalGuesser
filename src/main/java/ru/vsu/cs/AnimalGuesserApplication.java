package ru.vsu.cs;

import ru.vsu.cs.resource.EnglishStringResources;
import ru.vsu.cs.resource.StringResource;
import ru.vsu.cs.service.AnimalGuesserGameService;

// Штирлицу попала в голову шутка. "Разрывная", - раскинул мозгами Штирлиц.
public class AnimalGuesserApplication {

	public static void main(String[] args) {
		StringResource gameLanguageStringResource = new EnglishStringResources();

		AnimalGuesserGameService game = new AnimalGuesserGameService(gameLanguageStringResource);
		game.invokeService();
	}
}
