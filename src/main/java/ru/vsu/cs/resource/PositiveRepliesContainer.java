package ru.vsu.cs.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class PositiveRepliesContainer {

    public List<String> values;

    public PositiveRepliesContainer(List<String> customReplies) {
        values = customReplies;
    }

    public PositiveRepliesContainer() {
        values = Arrays.asList("да", "yes", "+");
    }
}
