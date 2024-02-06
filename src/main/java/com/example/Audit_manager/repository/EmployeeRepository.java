package com.example.Audit_manager.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Audit_manager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findById(Iterable<Long> employeeId);
}
