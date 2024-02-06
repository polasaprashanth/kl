package com.example.Audit_manager.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Module_table")
public class Modules {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moduleId")
    private Long moduleId;

    @Column(name = "module_name", nullable = false)
    private String moduleName;

    // Other fields

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
    
    
    public Modules()
    {
    	
    }
    public Modules(Long moduleId, String module_name) {
		super();
		this.moduleId = moduleId;
		this.moduleName = module_name;
	}
    
    

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModule_name() {
		return moduleName;
	}

	public void setModule_name(String module_name) {
		this.moduleName = module_name;
	}
	@Override
	public String toString() {
		return "Modules [moduleId=" + moduleId + ", module_name=" + moduleName + "]";
	}

	
    
    
    
    
    
    
    
    
    

    
    
}
