package com.kibernumacademy.company.services;

import com.kibernumacademy.company.entities.Company;

public interface CompanyService {
  Company readByName(String name);
  Company create(Company company);
  Company update(Company company, String name);
  void delete(String name);
}
