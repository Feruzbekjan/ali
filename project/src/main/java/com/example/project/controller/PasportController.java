package com.example.project.controller;

import com.example.project.entity.Pasport;
import com.example.project.service.PasportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pasport")
public class PasportController {
    private final PasportService pasportService;

    public PasportController(PasportService pasportService) {
        this.pasportService = pasportService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Pasport pasport){
        if (pasportService.chekAge(pasport.getTugilgan_yili())){
            return new ResponseEntity("Pasport 16 ga to'lgandan keyin Beriladi", HttpStatus.BAD_REQUEST);
        }
        Pasport result=pasportService.save(pasport);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/get/{seria}")
    public ResponseEntity getById(@PathVariable Long seria){
        Pasport result=pasportService.getPasport(seria);
        return ResponseEntity.ok(result);
    }

}
