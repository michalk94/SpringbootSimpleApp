package pl.michalkwit.springbootsimpleapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CourseDTO {

    private String name;
    private Long id;
    private int lengthInSeconds;
}
