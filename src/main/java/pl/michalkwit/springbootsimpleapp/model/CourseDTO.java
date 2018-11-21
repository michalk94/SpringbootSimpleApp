package pl.michalkwit.springbootsimpleapp.model;


import lombok.Data;

@Data
public class CourseDTO {

    private String name;
    private int lengthInSeconds;
    private Long id;
}
