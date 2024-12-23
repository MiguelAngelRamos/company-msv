package com.kibernumacademy.company.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.kibernumacademy.company.entities.WebSite;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {
 WebSite findByUrl(String url);
}
