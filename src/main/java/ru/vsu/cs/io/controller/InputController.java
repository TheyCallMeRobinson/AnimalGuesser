package ru.vsu.cs.io.controller;

import ru.vsu.cs.resource.ResponseType;

public interface InputController {

    String readUserInput();
    ResponseType handleResponse();
    void closeInputChannel();
}
