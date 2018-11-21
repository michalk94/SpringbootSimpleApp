package pl.michalkwit.springbootsimpleapp.service;



import pl.michalkwit.springbootsimpleapp.model.CourseDTO;
import pl.michalkwit.springbootsimpleapp.persistence.model.Course;
import pl.michalkwit.springbootsimpleapp.persistence.repository.CourseRepo;

import java.util.List;

public interface CourseService<T> extends BaseService<Course, Long, CourseRepo> {

    CourseDTO getCourseDtoById(Long id);

    CourseDTO createCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();



}
