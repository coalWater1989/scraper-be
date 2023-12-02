package com.charbz.sendzbe.repository;

import com.charbz.sendzbe.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
