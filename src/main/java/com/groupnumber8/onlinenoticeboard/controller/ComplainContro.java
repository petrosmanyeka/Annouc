package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.ComplainModel;
import com.groupnumber8.onlinenoticeboard.entities.Complains;
import com.groupnumber8.onlinenoticeboard.repository.ComplainRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class ComplainContro {

    @Autowired
    private ComplainRepositor complainRepositor;

    @PostMapping("/com")
    public Complains saveComp(@RequestBody Complains complains){
        return complainRepositor.save(complains);
    }
    @GetMapping("/Coms")
    public List<Complains> getAllComplains(){
        return complainRepositor.findAll();
    }
    @DeleteMapping("/del/{id}")
    public String deletComplains(@PathVariable("id") Long id){
         complainRepositor.deleteById(id);
         return "deleted";
    }
}
