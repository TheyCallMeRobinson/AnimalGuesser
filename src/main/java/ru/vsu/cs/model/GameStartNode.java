package ru.vsu.cs.model;

import lombok.Data;

@Data
public class GameStartNode {

    private AnimalNode positiveResponseSubtree;
    private AnimalNode negativeResponseSubtree;
    private String startQuestion;
}