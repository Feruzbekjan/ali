package com.example.project.controller;

import com.example.project.entity.Xodim;
import com.example.project.service.XodimService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/xodim")
public class XodimController {
    private final XodimService xodimService;


    public XodimController(XodimService xodimService) {
        this.xodimService = xodimService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Xodim xodim){
        if (xodimService.chekAge(xodim.getAge())){
            return new ResponseEntity("bizda 18 yoshdan kattalar ishga olinadi", HttpStatus.BAD_REQUEST);
        }
        Xodim result=xodimService.save(xodim);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/updete")
    public ResponseEntity updete(@PathVariable Long id,@RequestBody Xodim updeteXodim){
        Xodim result=xodimService.updete(id,updeteXodim);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@PathVariable Long id){
        xodimService.deleteById(id);
        return ResponseEntity.ok("xodim malumotlari o'chirildi");
    }
    @GetMapping("/get")
    public ResponseEntity getById(@PathVariable Long id){
        Xodim result=xodimService.finById(id);
        return ResponseEntity.ok(result);
    }
}
