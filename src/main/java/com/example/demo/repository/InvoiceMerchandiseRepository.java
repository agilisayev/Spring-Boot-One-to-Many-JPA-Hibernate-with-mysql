package com.example.demo.repository;

import com.example.demo.domain.InvoiceMerchandise;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface InvoiceMerchandiseRepository extends CrudRepository<InvoiceMerchandise, Long> {
    List<InvoiceMerchandise> findAll();
}
