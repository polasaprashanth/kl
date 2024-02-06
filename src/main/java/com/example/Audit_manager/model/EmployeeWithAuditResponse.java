package com.example.Audit_manager.model;

public class EmployeeWithAuditResponse {
    private Employee employee;
    private AuditDetails auditDetails;

    // Constructors, getters, and setters

    
    public EmployeeWithAuditResponse() {}
    public EmployeeWithAuditResponse(Employee employee, AuditDetails auditDetails) {
        this.employee = employee;
        this.auditDetails = auditDetails;
    }
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public AuditDetails getAuditDetails() {
		return auditDetails;
	}
	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}
	@Override
	public String toString() {
		return "EmployeeWithAuditResponse [employee=" + employee + ", auditDetails=" + auditDetails + "]";
	}

    // Other methods if needed
    
    
    
}
