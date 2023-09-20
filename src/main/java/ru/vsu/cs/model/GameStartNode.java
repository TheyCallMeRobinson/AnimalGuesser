package ru.vsu.cs.model;

import lombok.Data;

@Data
public class GameStartNode {

    public AnimalNode positiveResponseSubtree;
    public AnimalNode negativeResponseSubtree;
    public String startQuestion;
}