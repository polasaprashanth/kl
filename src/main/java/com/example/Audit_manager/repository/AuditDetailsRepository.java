package com.example.Audit_manager.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Audit_manager.model.AuditDetails;
import com.example.Audit_manager.model.Employee;
import java.util.Optional;

public interface AuditDetailsRepository extends JpaRepository<AuditDetails, Long> {
    org.apache.el.stream.Optional findByEntityTableId(Long entityTableId);

	void deleteByEntityTableId(Long employeeId);
}
