package com.example.project.controller;

import com.example.project.entity.Lavozim;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lavozim")
@CrossOrigin(value = "*")
public class LavozimController {

    @PostMapping("direktor")
    public Lavozim direktor(){
       return Lavozim.builder().id(1L).name("Direktor").build();
    }
    @PostMapping("bolimboshliq")
    public Lavozim bolimboshliq(){
        return Lavozim.builder().id(2L).name("Bo'lim boshliq").build();
    }
    @PostMapping("xodim")
    public Lavozim xodim(){
        return Lavozim.builder().id(1L).name("Xodim").build();
    }
}
