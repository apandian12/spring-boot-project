package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.List;

public interface ListRepository extends JpaRepository<List, Long> {
	
	

}
