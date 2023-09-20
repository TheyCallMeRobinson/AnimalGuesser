package ru.vsu.cs.model;

import lombok.Data;

@Data
public class QuestionNode {

    public AnimalNode nextAnimal;
    public String questionText;
}