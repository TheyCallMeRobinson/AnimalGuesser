package ru.vsu.cs.io.controller;

public interface OutputController {

    void showMessage(String message);
    void onNewGameStartMessage(String startQuestion);
    void animalDecisionMessage(String animalName);
    void onGameLooseAskAnimalName();
    void onGameLooseAskAnimalFeature(String newAnimalName, String currentAnimalName);
    void onGameOverAskForNextGame();
    void onGameOverFarewell();
    void onUnclearResponseMessage();
    void onReadFileMessage();
    void onSaveStateMessage();
}
