package com.example.demo.servicies;

import com.example.demo.domain.Invoice;
import com.example.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice save(Invoice invoice) {
        if (invoice.getInvoiceMerchandises() != null) {
            invoice.getInvoiceMerchandises().forEach(invoiceMerchandise -> {
                invoiceMerchandise.setInvoice(invoice);
            });
        }
        return invoiceRepository.save(invoice);
    }

    public Invoice findByID(Long id) {
        return invoiceRepository.findOne(id);
    }

}
