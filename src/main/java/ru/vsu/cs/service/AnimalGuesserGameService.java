package ru.vsu.cs.service;

import ru.vsu.cs.container.ResponseType;
import ru.vsu.cs.io.InputController;
import ru.vsu.cs.io.OutputController;
import ru.vsu.cs.io.impl.ConsoleInputController;
import ru.vsu.cs.io.impl.ConsoleOutputController;
import ru.vsu.cs.model.AnimalNode;
import ru.vsu.cs.model.GameStartNode;
import ru.vsu.cs.model.QuestionNode;

import java.util.ArrayList;

public class AnimalGuesserGameService {

    private GameStartNode gameStartNode;
    private InputController inputController;
    private OutputController outputController;
    private AnimalNode currentAnimal;
    private Boolean gameOverFlag;

    public AnimalGuesserGameService(GameStartNode startAnimal) {
        gameStartNode = startAnimal;
        gameOverFlag = false;
        inputController = new ConsoleInputController();
        outputController = new ConsoleOutputController();
    }

    public void invokeService() {
        onNewGameStart();
    }

    private void onNewGameStart() {
        outputController.onNewGameStartMessage(gameStartNode.getStartQuestion());

        if (inputController.handleResponse() == ResponseType.POSITIVE) {
            currentAnimal = gameStartNode.getPositiveResponseSubtreeRoot();
        } else {
            currentAnimal = gameStartNode.getNegativeResponseSubtreeRoot();
        }

        gameLoop();
    }

    private void gameLoop() {
        while(!gameOverFlag) {
            onNextQuestion();
        }
    }

    private void onNextQuestion() {
        outputController.animalDecisionMessage(currentAnimal.getAnimalName());

        if (inputController.handleResponse() == ResponseType.POSITIVE) {
            onGameOver();
        } else {
            onNegativeResponse();
        }
    }

    private void onNegativeResponse() {
        for (var question : currentAnimal.getQuestions()) {
            outputController.animalDecisionMessage(question.getQuestionText());
            if (inputController.handleResponse() == ResponseType.POSITIVE) {
                currentAnimal = question.getNextAnimal();
                return;
            }
        }
        onGameLoose();
        onGameOver();
    }

    private void onPositiveResponse() {}

    private void onGameLoose() {
        outputController.onGameLooseAskAnimalName();
        String animalName = inputController.readUserInput();
        outputController.onGameLooseAskAnimalFeature(animalName, currentAnimal.getAnimalName());
        String animalFeature = inputController.readUserInput();
        currentAnimal.getQuestions().add(new QuestionNode(new AnimalNode(animalName, new ArrayList<>()), animalFeature));
    }

    private void onGameOver() {
        outputController.onGameOverAskForNextGame();
        ResponseType responseType = inputController.handleResponse();
        if (responseType == ResponseType.POSITIVE) {
            onNewGameStart();
        } else {
            outputController.onGameOverFarewell();
            inputController.closeInputChannel();
            gameOverFlag = true;
        }
    }

}
