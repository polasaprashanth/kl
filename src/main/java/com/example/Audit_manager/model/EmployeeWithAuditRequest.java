	package com.example.Audit_manager.model;
	public class EmployeeWithAuditRequest {
	    private Employee employee;
	    private AuditDetails auditDetails;
	    
	    public EmployeeWithAuditRequest()
	    {
	    	
	    }
		public EmployeeWithAuditRequest(Employee employee, AuditDetails auditDetails) {
			super();
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
			return "EmployeeWithAuditRequest [employee=" + employee + ", auditDetails=" + auditDetails + "]";
		}
	
	    // Constructors, getters, and setters
	    
	}
	
