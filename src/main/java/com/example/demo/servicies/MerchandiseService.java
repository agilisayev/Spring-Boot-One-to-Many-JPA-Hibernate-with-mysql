package com.example.demo.servicies;

import com.example.demo.domain.Merchandise;
import com.example.demo.repository.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MerchandiseService {


    private final MerchandiseRepository merchandiseRepository;
    @Autowired
    public MerchandiseService(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    public List<Merchandise> findAll() {
        return merchandiseRepository.findAll();
    }

    public Merchandise findById(Long id) {
        return merchandiseRepository.findOne(id);
    }

    public Merchandise save(Merchandise merchandise) {
        return merchandiseRepository.save(merchandise);
    }

    public void delete(Long id) {
        Merchandise merchandise = findById(id);
        merchandiseRepository.delete(merchandise);
    }

}
