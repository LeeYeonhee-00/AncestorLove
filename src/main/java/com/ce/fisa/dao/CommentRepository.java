package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ce.fisa.model.entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	Comment findByComId(long comId);
}
