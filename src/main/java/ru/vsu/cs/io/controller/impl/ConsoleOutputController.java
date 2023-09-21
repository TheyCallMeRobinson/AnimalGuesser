package ru.vsu.cs.io.controller.impl;

import ru.vsu.cs.io.controller.OutputController;
import ru.vsu.cs.io.controller.Printer;
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
        String message = stringResource.getNewGameGreetingMessage();
        consolePrinter.printNewLineMessage(message);
        animalDecisionMessage(startQuestion);
    }

    @Override
    public void animalDecisionMessage(String animalName) {
        String formattedMessage = stringResource.getAnimalAssumptionMessageFormatted();
        consolePrinter.printFormattedMessage(formattedMessage, animalName);
    }

    @Override
    public void onGameLooseAskAnimalName() {
        String message = stringResource.getWhatAnimalWasWishedMessage();
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onGameLooseAskAnimalFeature(String newAnimalName, String currentAnimalName) {
        String formattedMessage = stringResource.getHowDoesWishedAnimalDifferMessageFormatted();
        consolePrinter.printFormattedMessage(formattedMessage, newAnimalName, currentAnimalName);
    }

    @Override
    public void onGameOverAskForNextGame() {
        String message = stringResource.getNextGameQuestionMessage();
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onGameOverFarewell() {
        String message = stringResource.getFarewellMessage();
        consolePrinter.printNewLineMessage(message);
    }

    @Override
    public void onUnclearResponseMessage() {
        String message = stringResource.getUnclearResponseMessage();
        consolePrinter.printNewLineMessage(message);
    }
}
