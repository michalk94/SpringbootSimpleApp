package pl.michalkwit.springbootsimpleapp.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;


    @PrePersist
    protected void logDateBeforeInsert(){
      this.createdDate = new Date();
      this.updatedDate = new Date();
      this.active = true;
    }
    @PreUpdate
    protected void logDateBeforeUpdate(){
        this.updatedDate = new Date();
    }


    public boolean getActive() {
        return active;
    }
}
