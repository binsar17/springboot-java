package com.example.springboot2.springboot2postgresqljpahibernatecrud.repository;

import com.example.springboot2.springboot2postgresqljpahibernatecrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}