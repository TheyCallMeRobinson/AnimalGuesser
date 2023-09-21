package ru.vsu.cs.io.impl;

import ru.vsu.cs.container.NegativeRepliesContainer;
import ru.vsu.cs.container.PositiveRepliesContainer;
import ru.vsu.cs.container.ResponseType;
import ru.vsu.cs.io.InputController;
import ru.vsu.cs.io.OutputController;

import java.util.Scanner;

public class ConsoleInputController implements InputController {

    private final Scanner consoleScanner;
    private final NegativeRepliesContainer negativeReplies;
    private final PositiveRepliesContainer positiveReplies;
    private final OutputController outputController;

    public ConsoleInputController() {
        this.consoleScanner = new Scanner(System.in);
        this.negativeReplies = new NegativeRepliesContainer();
        this.positiveReplies = new PositiveRepliesContainer();
        this.outputController = new ConsoleOutputController();
    }

    @Override
    public String readUserInput() {
        return consoleScanner.nextLine();
    }

    @Override
    public ResponseType handleResponse() {
        ResponseType responseType = getUserResponse();
        while(responseType == ResponseType.UNCLEAR) {
            outputController.onUnclearResponseMessage();
            responseType = getUserResponse();
        }
        return responseType;
    }

    @Override
    public void closeInputChannel() {
        consoleScanner.close();
    }

    private ResponseType getUserResponse() {
        String response = readUserInput();
        if (positiveReplies.values.contains(response))
            return ResponseType.POSITIVE;
        if (negativeReplies.values.contains(response))
            return ResponseType.NEGATIVE;
        return ResponseType.UNCLEAR;
    }
}
