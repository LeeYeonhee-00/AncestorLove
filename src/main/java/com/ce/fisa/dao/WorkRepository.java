package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ce.fisa.model.entity.Work;
import java.util.List;


public interface WorkRepository extends JpaRepository<Work, Long> {

	Work findByWorkId(long workId);
}
