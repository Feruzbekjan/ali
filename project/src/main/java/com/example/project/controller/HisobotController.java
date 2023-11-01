package com.example.project.controller;

import com.example.project.service.HisobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hisobot")
public class HisobotController {
    private final HisobotService hisobotService;

    public HisobotController(HisobotService hisobotService) {
        this.hisobotService = hisobotService;
    }
    @GetMapping("/oylik_statistika")
    public ResponseEntity<Map<String, Integer>> getOylikStatistika() {
        Map<String, Integer> statistika =hisobotService.oylikstatistika();
        return ResponseEntity.ok(statistika);
    }

    @GetMapping("/ishxodimlar")
    public ResponseEntity<List<Map<String, Object>>> getIshXodimlar() {
        List<Map<String, Object>> workedEmployees = hisobotService.getIshXodimlar();
        return ResponseEntity.ok(workedEmployees);
    }

    @GetMapping("/kechEmployees")
    public ResponseEntity<List<Map<String, Object>>> getLateXodimlar() {
        List<Map<String, Object>> lateEmployees = hisobotService.kechqolganlar();
        return ResponseEntity.ok(lateEmployees);
    }
    @GetMapping("/oylik xodim_id")
    public ResponseEntity oylik(@PathVariable Long id){
        return ResponseEntity.ok(hisobotService.oyliklar(id));
    }



}
