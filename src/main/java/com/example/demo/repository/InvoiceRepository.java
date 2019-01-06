package com.example.demo.repository;

import com.example.demo.domain.Invoice;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    List<Invoice> findAll();
}
