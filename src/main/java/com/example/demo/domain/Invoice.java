package com.example.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(updatable = false)
    private Date tarix;

    @Column(insertable = false)
    private Date updateTarix;

    private BigDecimal total;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InvoiceMerchandise> invoiceMerchandises;

    public Invoice() {
    }

    public Invoice(String name, Date tarix, Date updateTarix, BigDecimal total, List<InvoiceMerchandise> invoiceMerchandises) {
        this.name = name;
        this.tarix = tarix;
        this.updateTarix = updateTarix;
        this.total = total;
        this.invoiceMerchandises = invoiceMerchandises;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTarix() {
        return new Date();
    }

    public BigDecimal getTotal() {
        if (total == null) {
            return BigDecimal.ZERO;
        }
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setTarix(Date tarix) {
        this.tarix = new Date();
    }


    @PrePersist
    public void setTarix() {
        this.tarix = new Date();
    }

    @PreUpdate
    public void serUpdateTarix() {
        this.updateTarix = new Date();
    }

    public List<InvoiceMerchandise> getInvoiceMerchandises() {
        return invoiceMerchandises;
    }

    public void setInvoiceMerchandises(List<InvoiceMerchandise> invoiceMerchandises) {
        this.invoiceMerchandises = invoiceMerchandises;
    }
}
