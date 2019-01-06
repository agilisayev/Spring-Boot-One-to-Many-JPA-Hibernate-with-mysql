package com.example.demo.controller;

import com.example.demo.domain.Merchandise;
import com.example.demo.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api2")
public class MainController {

    @GetMapping("test/{say}/{qiymet}/aqil")
    public BigDecimal test1(
            @PathVariable BigDecimal say,
            @PathVariable BigDecimal qiymet) {
        return say.multiply(qiymet);
    }

    @GetMapping("test/aqil")
    public BigDecimal test2(@RequestParam BigDecimal say, @RequestParam(defaultValue = "0", required = true) BigDecimal qiymet) {
        return say.multiply(qiymet);
    }

    @PostMapping("insert")
    public Person insert(@RequestBody Person person) {
        person.setId(UUID.randomUUID().toString());
        return person;
    }

    @GetMapping("test/person/{id}")
    public Person test3() {
        Person p = new Person();
        p.setId(UUID.randomUUID().toString());
        p.setName("Aqil");
        p.setSurname("Isa");
        return p;
    }

    @RequestMapping(name = "insert", method = RequestMethod.POST)
    public Person insert1(@RequestBody Person person) {
        //person crud
        person.setId(UUID.randomUUID().toString());
        return person;
    }
}
