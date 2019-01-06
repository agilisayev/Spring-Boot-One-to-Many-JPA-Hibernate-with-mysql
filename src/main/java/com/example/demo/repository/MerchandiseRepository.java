package com.example.demo.repository;

import com.example.demo.domain.Merchandise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MerchandiseRepository extends CrudRepository<Merchandise, Long> {
     List<Merchandise> findAll();
}
