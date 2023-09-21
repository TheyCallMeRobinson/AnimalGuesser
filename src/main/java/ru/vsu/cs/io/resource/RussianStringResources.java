package ru.vsu.cs.io.resource;

public class RussianStringResources implements StringResource {

    public final String getPositiveResponseSubtreeRootAnimalName() {
        return "Кот";
    }

    public final String getNegativeResponseSubtreeRootAnimalName() {
        return "Кит";
    }

    public final String getStartQuestion() {
        return "живёт на земле";
    }

    public final String getNewGameGreetingMessage() {
        return "\nЗагадайте животное, а я попробую угадать...";
    }

    public final String getAnimalAssumptionMessageFormatted() {
        return "Это животное %s?\n";
    }

    public final String getWhatAnimalWasWishedMessage() {
        return "Какое животное вы загадали?";
    }

    public final String getHowDoesWishedAnimalDifferMessageFormatted() {
        return "Чем \"%s\" отличается от \"%s\"?\n";
    }

    public final String getNextGameQuestionMessage() {
        return "Хотите сыграть ещё раз?";
    }

    public final String getFarewellMessage() {
        return "Спасибо за игру, до новых встреч!";
    }

    public final String getUnclearResponseMessage() {
        return "Я не понял, что вы имели ввиду, пожалуйста, повторите свой ответ";
    }
}
