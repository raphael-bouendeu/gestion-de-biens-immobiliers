package com.itbcafrica.gestionnairemaison.repository;

import com.itbcafrica.gestionnairemaison.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
