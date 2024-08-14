package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ce.fisa.model.dto.UserDTO;
import com.ce.fisa.model.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

	User findByUserEmail(String userEmail);

}
