package ru.vsu.cs.io;

import ru.vsu.cs.container.ResponseType;

public interface InputController {

    String readUserInput();
    ResponseType handleResponse();
    void closeInputChannel();
}
