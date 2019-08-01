package com.procare.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.procare.model.Employee;
@Repository
public interface UserRepo extends JpaRepository<Employee, Long>{

	
	@Query("FROM User WHERE name = ?1")
    List<Employee> findByName(String name, Sort sort);
}
