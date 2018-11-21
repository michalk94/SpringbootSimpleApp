package pl.michalkwit.springbootsimpleapp.service;

import pl.michalkwit.springbootsimpleapp.model.CourseDTO;
import pl.michalkwit.springbootsimpleapp.persistence.model.Course;

public class Mapper {

    public static CourseDTO courseToDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setLengthInSeconds(0);
        return courseDTO;
    }
    public static Course dtoToCourse(CourseDTO courseDTO){
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        return course;
    }
}
