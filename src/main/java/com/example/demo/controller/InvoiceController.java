package com.example.demo.controller;

import com.example.demo.domain.Invoice;
import com.example.demo.servicies.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

   private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping(value = "/save")
    public Invoice save(@RequestBody Invoice model) {
        return invoiceService.save(model);
    }

    @GetMapping(value = "/{id}")
    public Invoice findByID(@PathVariable Long id) {
        return invoiceService.findByID(id);
    }

}
