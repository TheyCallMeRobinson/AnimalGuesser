package ru.vsu.cs.io.impl;

import ru.vsu.cs.io.OutputController;
import ru.vsu.cs.io.Printer;


public class ConsoleOutputController implements OutputController {

    private final Printer consolePrinter;

    public ConsoleOutputController() {
        consolePrinter = new ConsoleSystemOutPrinter();
    }

    @Override
    public void showMessage(String message) {
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onNewGameStartMessage(String startQuestion) {
        String message = "\nЗагадайте животное, а я попробую угадать...";
        consolePrinter.printNewLineMessage(message);
        animalDecisionMessage(startQuestion);
    }

    @Override
    public void animalDecisionMessage(String animalName) {
        String formattedMessage = "Это животное %s?\n";
        consolePrinter.printFormattedMessage(formattedMessage, animalName);
    }

    @Override
    public void onGameLooseAskAnimalName() {
        String message = "Какое животное вы загадали?";
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onGameLooseAskAnimalFeature(String newAnimalName, String currentAnimalName) {
        String formattedMessage = "Чем \"%s\" отличается от \"%s\"?\n";
        consolePrinter.printFormattedMessage(formattedMessage, newAnimalName, currentAnimalName);
    }

    @Override
    public void onGameOverAskForNextGame() {
        String message = "Хотите сыграть ещё раз?";
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onGameOverFarewell() {
        String message = "Спасибо за игру, до новых встреч!";
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onUnclearResponseMessage() {
        String message = "Я не понял, что вы имели ввиду, пожалуйста, повторите свой ответ";
        consolePrinter.printNewLineMessage(message);
    }
}
