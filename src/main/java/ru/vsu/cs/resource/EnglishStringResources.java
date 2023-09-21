package ru.vsu.cs.resource;

public class EnglishStringResources implements StringResource {

    public String getPositiveResponseSubtreeRootAnimalName() {
        return "Cat";
    }

    public String getNegativeResponseSubtreeRootAnimalName() {
        return "Whale";
    }

    public String getStartQuestion() {
        return "lives on ground";
    }

    public String getNewGameGreetingMessage() {
        return "\nWish an animal, and I will try to guess it...";
    }

    public String getAnimalAssumptionMessageFormatted() {
        return "Is this animal %s?\n";
    }

    public String getWhatAnimalWasWishedMessage() {
        return "What animal did you wish?";
    }

    public String getHowDoesWishedAnimalDifferMessageFormatted() {
        return "How does \"%s\" differ from \"%s\"?\n";
    }

    public String getNextGameQuestionMessage() {
        return "Do you want to play again?";
    }

    public String getFarewellMessage() {
        return "Thank you for the game, goodbye!";
    }

    public String getUnclearResponseMessage() {
        return "I didn't understand what you meant, please repeat your answer";
    }

    public String getReadSaveFileMessage() {
        return "Would you like to read save file?";
    }

    public String getSaveGameStateMessage() {
        return "Would you like to save game state?";
    }
}
