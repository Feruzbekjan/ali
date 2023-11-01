package com.example.project.service;

import com.example.project.entity.Bolim;
import com.example.project.repository.BolimRepository;
import org.springframework.stereotype.Service;

@Service
public class BolimService {
    private final BolimRepository bolimRepository;


    public BolimService(BolimRepository bolimRepository) {
        this.bolimRepository = bolimRepository;
    }

    public Bolim add(Bolim bolim){
        return bolimRepository.save(bolim);
    }

    public void delete(Long id){
        bolimRepository.deleteById(id);
    }



}
