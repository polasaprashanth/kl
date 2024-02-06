package com.example.Audit_manager.model;



import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.Audit_manager.audit.Transactionn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "Transaction_table")
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends Transactionn <String>{
	
	  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionId")
    private Long transactionId;

    @Column(name = "transactionType", nullable = false)
    private String transactionType; // Created, Updated, Deleted

    @Column(name = "description", nullable = false)
    private String description; // description

    @Column(name = "transactionStatus", nullable = false)
    private String transactionStatus;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false, foreignKey = @ForeignKey(name = "FK_transaction_module"))
    private Modules module;
	  
	  
	  public Transaction() {
		  
	  }

	public Transaction(Long transactionId, String transactionType, String description, String transactionStatus,
			Modules module) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.description = description;
		this.transactionStatus = transactionStatus;
		this.module = module;
	}
	
	 public Modules getModule() {
	        return module;
	    }

	    public void setModule(Modules module) {
	        this.module = module;
	    }

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId2) {
		this.transactionId = transactionId2;
	}

	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransaction_status() {
		return transactionStatus;
	}

	public void setTransaction_status(String transaction_status) {
		transactionStatus = transaction_status;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType + ", description="
				+ description + ", Transaction_status=" + transactionStatus + "]";
	}

	
	  
	  
	
	  
	  
	  
	  
	  
	

	
	
	
	  
	  
	  
	  
	  
	  
	  

	  
	  

	  

	
	
	
	  
	
		
	  
	   

}
