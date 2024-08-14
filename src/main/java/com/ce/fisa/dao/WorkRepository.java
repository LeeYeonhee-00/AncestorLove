package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ce.fisa.model.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {

}
