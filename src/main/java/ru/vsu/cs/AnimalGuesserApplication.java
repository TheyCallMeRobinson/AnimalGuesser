package ru.vsu.cs;

import ru.vsu.cs.model.AnimalNode;
import ru.vsu.cs.model.GameStartNode;
import ru.vsu.cs.service.AnimalGuesserGameService;

import java.util.ArrayList;

public class AnimalGuesserApplication {

	public static void main(String[] args) {
		GameStartNode gameStartNode = new GameStartNode(
				new AnimalNode("Кот", new ArrayList<>()),
				new AnimalNode("Кит", new ArrayList<>()),
				"живет на земле"
		);

		AnimalGuesserGameService game = new AnimalGuesserGameService(gameStartNode);
		game.invokeService();
	}
}
