package pl.michalkwit.springbootsimpleapp;


import lombok.Data;

@Data
public class Course {

    private String name;
    private int lengthInSeconds;
    private Long id;
}
