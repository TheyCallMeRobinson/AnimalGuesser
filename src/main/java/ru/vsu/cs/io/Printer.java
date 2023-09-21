package ru.vsu.cs.io;

public interface Printer {

    void printFormattedMessage(String formattedMessage, Object ... args);
    void printNewLineMessage(String message);
}
