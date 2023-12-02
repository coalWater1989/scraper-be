package com.charbz.sendzbe.repository;

import com.charbz.sendzbe.entity.Send;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SendRepository extends CrudRepository<Send, Integer> {
    @Query("from Send where username = :username ")
    Iterable<Send> findAllByUsername(@Param("username") String username);
}
