package pl.michalkwit.springbootsimpleapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.michalkwit.springbootsimpleapp.persistence.model.BaseEntity;

import java.io.Serializable;

public interface BaseRepository<T extends BaseEntity, K extends Serializable>
        extends JpaRepository<T, K>, JpaSpecificationExecutor<T> {


}
