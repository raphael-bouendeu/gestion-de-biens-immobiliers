package com.itbcafrica.gestionnairemaison.repository;

import com.itbcafrica.gestionnairemaison.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;


public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
