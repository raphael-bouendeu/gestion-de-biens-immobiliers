package com.itbcafrica.gestionnairemaison.repository;

import com.itbcafrica.gestionnairemaison.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
    List<PropertyEntity> findALlByUserEntityId(Long user_id);
}
