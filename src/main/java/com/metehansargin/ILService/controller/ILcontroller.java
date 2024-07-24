package com.metehansargin.ILService.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.metehansargin.ILService.model.Il;
import com.metehansargin.ILService.sevice.Ilservice;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/iller")
@AllArgsConstructor
public class ILcontroller {

    private final Ilservice ilservice;
    @GetMapping 
    public ResponseEntity<List<Il>> getIller(){
        return new ResponseEntity<>(ilservice.getIller(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
        return new ResponseEntity<>(getIlById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Il> createIl(@RequestBody Il newIl){
        return new ResponseEntity<>(ilservice.createIl(newIl),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        ilservice.deleteIl(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> getIl(@PathVariable String id,@RequestBody Il newIl){
        ilservice.updateIl(id,newIl);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private Il getIlById(String id){
        return ilservice.getIlById(id);
    }
}
