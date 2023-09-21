package ru.vsu.cs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionNode {

    private AnimalNode nextAnimal;
    private String questionText;
}