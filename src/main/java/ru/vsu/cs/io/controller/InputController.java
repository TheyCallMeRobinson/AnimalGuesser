package ru.vsu.cs.io.controller;

import ru.vsu.cs.container.ResponseType;

public interface InputController {

    String readUserInput();
    ResponseType handleResponse();
    void closeInputChannel();
}
