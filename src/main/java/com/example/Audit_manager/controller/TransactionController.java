package com.example.Audit_manager.controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.Audit_manager.model.Modules;
import com.example.Audit_manager.model.Transaction;
import com.example.Audit_manager.repository.ModuleRepository;
import com.example.Audit_manager.repository.TransactionRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
	
	@Autowired
    private TransactionRepository transactionRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	
	
	

	@PostMapping("/Transactioncreate")
	public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
	    // Assuming you have moduleId in the request payload
	    Long moduleId = transaction.getModule().getModuleId();
	    Modules module = moduleRepository.findById(moduleId).orElse(null);

	    if (module == null) {
	        // Handle the case when the module is not found
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    transaction.setModule(module);

	    Transaction createdTransaction = transactionRepository.save(transaction);
	    return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
	}


    @GetMapping("/Transactiondetails")
    public ResponseEntity<List<Transaction>> getAllTransactionDetails() {
        List<Transaction> transactionList = transactionRepository.findAll();
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }
    
    @PutMapping("/UpdateTransaction/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable Long transactionId,
            @Valid @RequestBody Transaction updatedTransaction) {

        // Check if the transaction with the given ID exists
        if (!transactionRepository.existsById(transactionId)) {
            return ResponseEntity.notFound().build();
        }

        // Update fields based on your requirements
        // Assuming you want to update the associated module as well
        Long moduleId = updatedTransaction.getModule().getModuleId();
        Modules module = moduleRepository.findById(moduleId).orElse(null);

        if (module == null) {
            return ResponseEntity.notFound().build();
        }

        updatedTransaction.setModule(module);

        // Set the transactionId explicitly to avoid any confusion
        updatedTransaction.setTransactionId((transactionId));

        // Save the updated transaction
        Transaction updatedTransactionResult = transactionRepository.save(updatedTransaction);

        return ResponseEntity.ok(updatedTransactionResult);
    }
    
    
}
