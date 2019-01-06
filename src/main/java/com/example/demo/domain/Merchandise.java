package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_merchandise")
public class Merchandise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(updatable = true)
    private String info;

    public Merchandise() {
    }

    public Merchandise(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
