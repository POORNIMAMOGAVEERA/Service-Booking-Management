package com.cts.usermanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.usermanagement.model.AppUser;

@Repository
public interface UserDao extends CrudRepository<AppUser, Integer> {

}
