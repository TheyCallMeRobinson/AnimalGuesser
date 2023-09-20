package ru.vsu.cs.container;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class NegativeRepliesContainer {

    public List<String> values;

    public NegativeRepliesContainer(List<String> customReplies) {
        values = customReplies;
    }

    public NegativeRepliesContainer() {
        values = Arrays.asList("нет", "no", "-");
    }
}
