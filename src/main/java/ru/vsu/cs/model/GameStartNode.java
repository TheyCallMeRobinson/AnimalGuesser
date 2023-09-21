package ru.vsu.cs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameStartNode {

    private AnimalNode positiveResponseSubtreeRoot;
    private AnimalNode negativeResponseSubtreeRoot;
    private String startQuestion;
}