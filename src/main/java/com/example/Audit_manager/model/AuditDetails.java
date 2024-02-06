package com.example.Audit_manager.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class AuditDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "audit_type")
    private String auditType;
    

    @Column(name = "log_level_id")
    private String logLevelId;

    @Column(name = "risk_level_id")
    private String riskLevelId;

    @Column(name = "source")
    private String source;

    @Column(name = "entity_table_id")
    private Long entityTableId;

    @Column(name = "entity_pk_id")
    private Long entityPkId;

    // Constructors, getters, and setters

    // Constructors
    public AuditDetails() {
    }

    
	public AuditDetails(Long id, String auditType, String logLevelId, String riskLevelId, String source,
			Long entityTableId, Long entityPkId) {
		super();
		this.id = id;
		this.auditType = auditType;
		this.logLevelId = logLevelId;
		this.riskLevelId = riskLevelId;
		this.source = source;
		this.entityTableId = entityTableId;
		this.entityPkId = entityPkId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getLogLevelId() {
		return logLevelId;
	}

	public void setLogLevelId(String logLevelId) {
		this.logLevelId = logLevelId;
	}

	public String getRiskLevelId() {
		return riskLevelId;
	}

	public void setRiskLevelId(String riskLevelId) {
		this.riskLevelId = riskLevelId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getEntityTableId() {
		return entityTableId;
	}

	public void setEntityTableId(Long entityTableId) {
		this.entityTableId = entityTableId;
	}

	public Long getEntityPkId() {
		return entityPkId;
	}

	public void setEntityPkId(Long entityPkId) {
		this.entityPkId = entityPkId;
	}

	@Override
	public String toString() {
		return "AuditDetails [id=" + id + ", auditType=" + auditType + ", logLevelId=" + logLevelId + ", riskLevelId="
				+ riskLevelId + ", source=" + source + ", entityTableId=" + entityTableId + ", entityPkId=" + entityPkId
				+ "]";
	}


	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

    
}

