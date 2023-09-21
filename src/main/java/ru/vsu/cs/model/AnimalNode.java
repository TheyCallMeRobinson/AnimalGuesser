package ru.vsu.cs.model;

import lombok.Data;

import java.util.List;

@Data
public class AnimalNode {

    private String animalName;
    private List<QuestionNode> questions;
}