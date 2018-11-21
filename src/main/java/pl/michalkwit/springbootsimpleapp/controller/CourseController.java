package pl.michalkwit.springbootsimpleapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import pl.michalkwit.springbootsimpleapp.model.CourseDTO;
import pl.michalkwit.springbootsimpleapp.exception.WrongIdException;
import pl.michalkwit.springbootsimpleapp.persistence.model.Course;
import pl.michalkwit.springbootsimpleapp.service.CourseService;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/course")
public class CourseController {


    private List<CourseDTO> course = new ArrayList<>();

    @Autowired
    CourseService courseService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        if (courseDTO.getId() != null)
            throw new WrongIdException("Course should not have id");
        System.out.println(courseDTO.getName());
        CourseDTO dto = courseService.createCourse(courseDTO);
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAvailableCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public CourseDTO buyCourse(@PathVariable(value = "id") Long id) {
        System.out.println("buyCourse");
        return null;

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
