package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_invoice_merchandise")
public class InvoiceMerchandise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal say;

    private BigDecimal qiymet;

    private BigDecimal mebleg;

    @ManyToOne
    @JsonIgnore
    private Invoice invoice;

    @OneToOne
    private Merchandise merchandise;

    public InvoiceMerchandise() {
    }

    public InvoiceMerchandise(BigDecimal say, BigDecimal qiymet, BigDecimal mebleg, Invoice invoice, Merchandise merchandise) {
        this.say = say;
        this.qiymet = qiymet;
        this.mebleg = mebleg;
        this.invoice = invoice;
        this.merchandise = merchandise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSay() {
        return say;
    }

    public void setSay(BigDecimal say) {
        this.say = say;
    }

    public BigDecimal getQiymet() {
        return qiymet;
    }

    public void setQiymet(BigDecimal qiymet) {
        this.qiymet = qiymet;
    }

    public BigDecimal getMebleg() {
        return mebleg;
    }

    public void setMebleg(BigDecimal mebleg) {
        this.mebleg = mebleg;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }
}
