package ru.vsu.cs.service;

import ru.vsu.cs.container.ResponseType;
import ru.vsu.cs.io.controller.InputController;
import ru.vsu.cs.io.controller.OutputController;
import ru.vsu.cs.io.controller.impl.ConsoleInputController;
import ru.vsu.cs.io.controller.impl.ConsoleOutputController;
import ru.vsu.cs.io.gson.Gsonifier;
import ru.vsu.cs.io.resource.StringResource;
import ru.vsu.cs.model.AnimalNode;
import ru.vsu.cs.model.GameStartNode;
import ru.vsu.cs.model.QuestionNode;

import java.util.ArrayList;

public class AnimalGuesserGameService {

    private final InputController inputController;
    private final OutputController outputController;
    private final Gsonifier gsonifier;
    private GameStartNode gameStartNode;
    private AnimalNode currentAnimal;
    private Boolean gameOverFlag;

    public AnimalGuesserGameService(StringResource gameLanguageStringResource) {
        gameStartNode = new GameStartNode(
                new AnimalNode(gameLanguageStringResource.getPositiveResponseSubtreeRootAnimalName(), new ArrayList<>()),
                new AnimalNode(gameLanguageStringResource.getNegativeResponseSubtreeRootAnimalName(), new ArrayList<>()),
                gameLanguageStringResource.getStartQuestion()
        );
        gameOverFlag = false;
        outputController = new ConsoleOutputController(gameLanguageStringResource);
        inputController = new ConsoleInputController(outputController);
        gsonifier = new Gsonifier();
    }

    public void invokeService() {
        offerToReadSaveFile();
        onNewGameStart();
    }

    private void offerToReadSaveFile() {
        outputController.onReadFileMessage();
        if (inputController.handleResponse() == ResponseType.POSITIVE) {
            gameStartNode = gsonifier.readSavedGameStateFromFile();
        } else {
            GameStartNode savedData = gsonifier.readLastSavedGameState();
            if (savedData != null) {
                gameStartNode = gsonifier.readLastSavedGameState();
            }
        }
    }

    private void offerToSaveGameState() {
        outputController.onSaveStateMessage();
        if (inputController.handleResponse() == ResponseType.POSITIVE) {
            gsonifier.saveGameState(gameStartNode);
        }
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
        while (!gameOverFlag) {
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
            offerToSaveGameState();
            gameOverFlag = true;
            inputController.closeInputChannel();
        }
    }

    private void onSaveGameState() {

    }

    private void onLoadGameState() {

    }

}
