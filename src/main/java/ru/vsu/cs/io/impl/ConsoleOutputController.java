package ru.vsu.cs.io.impl;

import ru.vsu.cs.io.OutputController;
import ru.vsu.cs.io.Printer;
import ru.vsu.cs.io.resource.StringResource;


public class ConsoleOutputController implements OutputController {

    private final Printer consolePrinter;
    private final StringResource stringResource;

    public ConsoleOutputController(StringResource gameLanguageStringResource) {
        consolePrinter = new ConsoleSystemOutPrinter();
        stringResource = gameLanguageStringResource;
    }

    @Override
    public void showMessage(String message) {
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onNewGameStartMessage(String startQuestion) {
        String message = stringResource.NEW_GAME_GREETING_MESSAGE;
        consolePrinter.printNewLineMessage(message);
        animalDecisionMessage(startQuestion);
    }

    @Override
    public void animalDecisionMessage(String animalName) {
        String formattedMessage = stringResource.ANIMAL_ASSUMPTION_MESSAGE_FORMATTED;
        consolePrinter.printFormattedMessage(formattedMessage, animalName);
    }

    @Override
    public void onGameLooseAskAnimalName() {
        String message = stringResource.WHAT_ANIMAL_WAS_WISHED_MESSAGE;
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onGameLooseAskAnimalFeature(String newAnimalName, String currentAnimalName) {
        String formattedMessage = stringResource.HOW_DOES_WISHED_ANIMAL_DIFFER_MESSAGE_FORMATTED;
        consolePrinter.printFormattedMessage(formattedMessage, newAnimalName, currentAnimalName);
    }

    @Override
    public void onGameOverAskForNextGame() {
        String message = stringResource.NEXT_GAME_QUESTION_MESSAGE;
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onGameOverFarewell() {
        String message = stringResource.FAREWELL_MESSAGE;
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onUnclearResponseMessage() {
        String message = stringResource.UNCLEAR_RESPONSE_MESSAGE;
        consolePrinter.printNewLineMessage(message);
    }
}
