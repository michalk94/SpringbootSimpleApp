package pl.michalkwit.springbootsimpleapp.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.michalkwit.springbootsimpleapp.persistence.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

}
