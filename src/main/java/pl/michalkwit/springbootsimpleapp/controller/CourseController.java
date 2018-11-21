package pl.michalkwit.springbootsimpleapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import pl.michalkwit.springbootsimpleapp.model.CourseDTO;
import pl.michalkwit.springbootsimpleapp.exception.WrongIdException;
import pl.michalkwit.springbootsimpleapp.persistence.model.Course;
import pl.michalkwit.springbootsimpleapp.persistence.repository.CourseRepo;
import pl.michalkwit.springbootsimpleapp.service.Mapper;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/course")
public class CourseController {


    private List<CourseDTO> course = new ArrayList<>();

    @Autowired
    CourseRepo courseRepo;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        if (courseDTO.getId() == null || courseDTO.getId() < 0)
            throw new WrongIdException("Id is null or is lower than 0");

        course.add(courseDTO);
        System.out.println(courseDTO.getName());
        System.out.println(courseDTO.getLengthInSeconds());
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAvailableCourses() {
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public CourseDTO buyCourse(@PathVariable(value = "id") Long id) {
        System.out.println("buyCourse");
        Course c = courseRepo.getOne(id);
        return Mapper.courseToDTO(c);

    }

    @RequestMapping(value = "/buy2", method = RequestMethod.POST)
    public CourseDTO buyCourse2(@RequestParam(value = "id") Long id) {
        System.out.println("buyCourse2");
        return getCourse(id);
    }

    private CourseDTO getCourse(Long id) {
        CourseDTO courseDTO = null;
        for (CourseDTO c : course) {
            if (c.getId() != null && c.getId().equals(id)) {
                courseDTO = c;
                break;
            }
        }
        if (courseDTO == null) {
            //TODO

        }
        return courseDTO;

    }

}
