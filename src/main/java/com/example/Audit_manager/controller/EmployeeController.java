package com.example.Audit_manager.controller;




import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Audit_manager.exception.ResourceNotFoundException;
import com.example.Audit_manager.model.AuditDetails;
import com.example.Audit_manager.model.Employee;
import com.example.Audit_manager.model.EmployeeWithAuditRequest;
import com.example.Audit_manager.model.EmployeeWithAuditResponse;
import com.example.Audit_manager.repository.AuditDetailsRepository;
import com.example.Audit_manager.repository.EmployeeRepository;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuditDetailsRepository auditDetailsRepository;

    @PostMapping("/createEmployeeWithAudit")
    public ResponseEntity<String> createEmployeeWithAudit(@RequestBody EmployeeWithAuditRequest request) {
        try {
            Employee employee = request.getEmployee();
            AuditDetails auditDetails = request.getAuditDetails();

            // Save Employee details
            Employee savedEmployee = employeeRepository.save(employee);

            // Set Entity details for AuditDetails
            auditDetails.setEntityTableId(savedEmployee.getId());
            auditDetails.setEntityPkId(savedEmployee.getId());

            // Save AuditDetails
            auditDetailsRepository.save(auditDetails);

            return new ResponseEntity<>("Employee and audit details created successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating employee and audit details.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //get
//    
//    
//    @GetMapping("/getEmployeeWithAudit/{employeeId}")
//    public ResponseEntity<EmployeeWithAuditResponse> getEmployeeWithAudit(@PathVariable Long employeeId) {
//        try {
//            Employee existingEmployee = employeeRepository.findById(employeeId)
//                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
//
//            // Retrieve AuditDetails associated with the employee
//            AuditDetails auditDetails = auditDetailsRepository.findByEntityTableId(employeeId);
//            
//            if (auditDetails.isPresent()) {
//                AuditDetails auditDetails1 = auditDetails1;
//
//                // Create a response object containing both Employee and AuditDetails
//                EmployeeWithAuditResponse response = new EmployeeWithAuditResponse(existingEmployee, auditDetails1);
//
//                return new ResponseEntity<>(response, HttpStatus.OK);
//            } else {
//                // Handle the case when audit details are not found
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (ResourceNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // Update operation
    @PutMapping("/updateEmployeeWithAudit/{employeeId}")
    public ResponseEntity<String> updateEmployeeWithAudit(@PathVariable Long employeeId,
                                                         @RequestBody EmployeeWithAuditRequest request) {
        try {
            Employee existingEmployee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

            Employee updatedEmployee = request.getEmployee();
            existingEmployee.setFirstName(updatedEmployee.getFirstName());  // Set other fields as needed

            // Save updated Employee details
            Employee savedEmployee = employeeRepository.save(existingEmployee);

            // Update Entity details for AuditDetails
            AuditDetails auditDetails = request.getAuditDetails();
            auditDetails.setEntityTableId(savedEmployee.getId());
            auditDetails.setEntityPkId(savedEmployee.getId());

            // Save AuditDetails
            auditDetailsRepository.save(auditDetails);

            return new ResponseEntity<>("Employee and audit details updated successfully.", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Employee not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating employee and audit details.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete operation
    @DeleteMapping("/deleteEmployeeWithAudit/{employeeId}")
    public ResponseEntity<String> deleteEmployeeWithAudit(@PathVariable Long employeeId) {
        try {
            Employee existingEmployee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

            // Delete AuditDetails associated with the employee
            auditDetailsRepository.deleteByEntityTableId(employeeId);

            // Delete Employee
            employeeRepository.delete(existingEmployee);

            return new ResponseEntity<>("Employee and audit details deleted successfully.", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Employee not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting employee and audit details.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
