package ru.vsu.cs.controller;

public interface OutputController {

    void showMessage();
    void onNewGameStartMessage();
    void animalDecisionMessage();
    void onGameLooseAskAnimalName();
    void onGameLooseAskAnimalFeature();
    void onGameOverAskForNextGame();
    void onGameOverFarewell();
}
