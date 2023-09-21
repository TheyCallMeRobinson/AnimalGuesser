package ru.vsu.cs.model;

import lombok.Data;

@Data
public class QuestionNode {

    private AnimalNode nextAnimal;
    private String questionText;
}