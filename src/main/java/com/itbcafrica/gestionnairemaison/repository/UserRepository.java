package com.itbcafrica.gestionnairemaison.repository;

import com.itbcafrica.gestionnairemaison.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
