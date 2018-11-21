package pl.michalkwit.springbootsimpleapp.persistence.model;


import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "courses")
public class Course  extends BaseEntity {

    @Column(name = "name")
    private String name;


}
