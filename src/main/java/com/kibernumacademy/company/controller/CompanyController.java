package com.kibernumacademy.company.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kibernumacademy.company.entities.Company;
import com.kibernumacademy.company.services.CompanyService;


@RestController
@RequestMapping("/company")
public class CompanyController {
  
  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping("{name}")
  public ResponseEntity<Company> getCompanyByName(@PathVariable String name) {
    return ResponseEntity.ok(this.companyService.readByName(name));
  }

  @PostMapping
  public ResponseEntity<Company> create(@RequestBody Company company) {
    return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
  }

  @PutMapping("{name}")
  public ResponseEntity<Company> update(@RequestBody Company company, @PathVariable String name) {
    return ResponseEntity.ok(this.companyService.update(company, name));
  }

  @DeleteMapping("{name}")
  public ResponseEntity<Void> delete(@PathVariable String name) {
    this.companyService.delete(name);
    return ResponseEntity.noContent().build();
  }




  
}
