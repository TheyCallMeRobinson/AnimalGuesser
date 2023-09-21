package ru.vsu.cs.io.controller;

public interface Printer {

    void printFormattedMessage(String formattedMessage, Object ... args);
    void printNewLineMessage(String message);
}
