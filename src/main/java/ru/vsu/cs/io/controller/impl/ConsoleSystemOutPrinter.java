package ru.vsu.cs.io.controller.impl;

import ru.vsu.cs.io.controller.Printer;

public class ConsoleSystemOutPrinter implements Printer {

    @Override
    public void printFormattedMessage(String formattedMessage, Object ... args) {
        System.out.printf(formattedMessage, args);
    }

    @Override
    public void printNewLineMessage(String message) {
        System.out.println(message);
    }
}
