package com.kibernumacademy.company.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kibernumacademy.company.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
   Optional<Company> findByName(String name);
}
