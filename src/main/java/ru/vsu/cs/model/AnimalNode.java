package ru.vsu.cs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AnimalNode {

    private String animalName;
    private List<QuestionNode> questions;
}