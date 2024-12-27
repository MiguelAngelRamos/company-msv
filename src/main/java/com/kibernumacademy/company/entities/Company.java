package com.kibernumacademy.company.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 32)
  private String name;

  @Column(length = 128)
  private String founder;

  @Column(length = 255)
  private String logo;

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyy")
  @Column(name="foundation_date") // es opcional en las ultimas versiones de spring boot
  private LocalDate foundationDate;

  @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
  @JsonManagedReference
  private List<WebSite> webSites;

}
