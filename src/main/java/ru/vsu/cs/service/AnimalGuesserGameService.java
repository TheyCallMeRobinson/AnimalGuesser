package ru.vsu.cs.service;

import ru.vsu.cs.controller.InputController;
import ru.vsu.cs.controller.OutputController;
import ru.vsu.cs.model.AnimalNode;
import ru.vsu.cs.model.GameStartNode;

public class AnimalGuesserGameService {

    private GameStartNode gameStartNode;
    private InputController inputController;
    private OutputController outputController;
    private AnimalNode currentAnimal;
    private Boolean gameOverFlag;

    public AnimalGuesserGameService(GameStartNode startAnimal) {
        gameStartNode = startAnimal;
        gameOverFlag = false;
    }

    public void invokeService() {}

    private void onNewGameStart() {}

    private void onNextQuestion() {}

    private void onNegativeResponse() {}

    private void onPositiveResponse() {}

    private void onGameLoose() {}

    private void onGameOver() {}

}
