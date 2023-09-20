package ru.vsu.cs.model;

import lombok.Data;

import java.util.List;

@Data
public class AnimalNode {

    public String animalName;
    public List<QuestionNode> questions;
}