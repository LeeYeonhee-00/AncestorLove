package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ce.fisa.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
