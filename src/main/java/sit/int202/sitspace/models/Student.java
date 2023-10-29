package sit.int202.sitspace.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private double score;
    private char grade;
}
