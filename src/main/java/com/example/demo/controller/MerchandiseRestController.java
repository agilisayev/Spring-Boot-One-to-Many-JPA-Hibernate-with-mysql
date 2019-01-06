package com.example.demo.controller;

import com.example.demo.domain.Merchandise;
import com.example.demo.servicies.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/merchandise")
public class MerchandiseRestController {

    @Autowired
    MerchandiseService merchandiseService;

    @GetMapping("/{id}")
    public Merchandise findById(@PathVariable Long id) {
        Merchandise merchandise = merchandiseService.findById(id);
        if (merchandise == null) {
            throw new IllegalArgumentException("Merchandise not found!");
        }
        return merchandise;
    }

    @GetMapping("/list")
    public List<Merchandise> getAll() {
        return merchandiseService.findAll();
    }

    @PostMapping("/save")
    public Merchandise save(@RequestBody Merchandise merchandise) throws Exception {
        /*
        if (merchandise.getId() != null) {
            Merchandise merchandise1 = merchandiseService.findById(merchandise.getId());
            if (merchandise1 != null) merchandiseService.save(merchandise);
            else
                throw new Exception("Not Found merchandise " + merchandise.getId());
        } else {
            merchandiseService.save(merchandise);
        }
        */
        merchandiseService.save(merchandise);
        return merchandise;
    }

    @DeleteMapping("/delete/{id}")
    public List<Merchandise> delete(@PathVariable Long id) {
        merchandiseService.delete(id);
        return merchandiseService.findAll();
    }

}
