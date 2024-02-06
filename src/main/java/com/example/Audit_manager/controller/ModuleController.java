package com.example.Audit_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Audit_manager.model.Modules;
import com.example.Audit_manager.repository.ModuleRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/Module")
public class ModuleController {
	@Autowired
    private ModuleRepository moduleRepository;

    @GetMapping("/Moduledetails")
    public ResponseEntity<List<Modules>> getModuleDetails() {
        List<Modules> modulesList = moduleRepository.findAll();
        return new ResponseEntity<>(modulesList, HttpStatus.OK);
    }

    @PostMapping("/Modulecreate")
    public ResponseEntity<Modules> createModule(@Valid @RequestBody Modules module) {
        Modules createdModule = moduleRepository.save(module);
        return new ResponseEntity<>(createdModule, HttpStatus.CREATED);
    }
	

}
