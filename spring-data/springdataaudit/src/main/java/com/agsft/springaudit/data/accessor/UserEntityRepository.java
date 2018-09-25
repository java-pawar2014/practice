package com.agsft.springaudit.data.accessor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agsft.springaudit.data.entity.UserEntity;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {

}
