package com.kibernumacademy.company.services;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.kibernumacademy.company.entities.Category;
import com.kibernumacademy.company.entities.Company;
import com.kibernumacademy.company.repositories.CompanyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

  private final CompanyRepository companyRepository;
  
  @Override
  public Company readByName(String name) {
    return this.companyRepository.findByName(name).orElseThrow( () -> new NoSuchElementException("Company not found"));
  }

  @Override
  public Company create(Company company) {
    company.getWebSites().forEach(webSite -> {
      if(Objects.isNull(webSite.getCategory())) {
        webSite.setCategory(Category.NONE);
      }
      webSite.setCompany(company);
    });
    // Guardar la compañia y sus sitios web relacionados
    return this.companyRepository.save(company);
  }

  @Override
  public Company update(Company company, String name) {
    // Buscar si existe la compañia
    // Company companyToUpdate = this.companyRepository.findByName(name).orElseThrow( () -> new NoSuchElementException("Company noit found"));
    Company companyToUpdate = this.readByName(name);

    // Actualizo la compañia
    companyToUpdate.setLogo(company.getLogo());
    companyToUpdate.setFoundationDate(company.getFoundationDate());
    companyToUpdate.setFounder(company.getFounder());
    // Guardar Cambios
    return this.companyRepository.save(companyToUpdate);

  }

  @Override
  public void delete(String name) {
    Company companyToDelete = this.readByName(name);
    this.companyRepository.delete(companyToDelete);
  }
  
}
