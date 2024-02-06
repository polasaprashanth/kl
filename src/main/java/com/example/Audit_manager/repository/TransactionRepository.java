package com.example.Audit_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Audit_manager.model.Modules;
import com.example.Audit_manager.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	

	 
}
