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

@RestController
@RequestMapping("/iller")
public class ILcontroller {
    /* 
    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public <List<Il> getiller1(){
        Il il1=new Il("19","Corum");
        Il il2=new Il("19","Corum");

        return Arrays.asList(il1,il2);

    }
*/ //alttaki get mapin diğer yazılışı ama önerilmiyor bazen hata verme şansı olabilir.

    private static final List<Il> iller =new ArrayList<>();
    public ILcontroller(){
        if(iller.isEmpty()){
            Il il1=new Il(new Date(0),"19","Corum");
        Il il2=new Il(new Date(0),"06","Ankara");
        iller.add(il1);
        iller.add(il2);
        }

    
    }
    @GetMapping 
    public ResponseEntity<List<Il>> getIller(){

        return new ResponseEntity<>(iller,HttpStatus.OK);

    }
    /*
     * Burada yaptığımız işlemler https kodu ile locale bağlanıyoruz
     * /iller ekliyoruz localhostumuza 
     * 2 adet il ekleme işlemi yapıyoruz bunları görmek için postman kullanabiliriz
     * GET metodu ile görüntüleyebiliriz.
     */


    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
/* 
        Il result2=null;
        for (int i = 0; i <iller.size(); i++) {
            Il il=iller.get(i);
            if(il.getId().equals(id)){
                result2=il;
            }
        }
        if(result2==null){
            new RuntimeException("Il not found");
        }
*/ // alttaki kodun farklı yazılışı 
        Il result =getIlById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Il> createIl(@RequestBody Il newIl){
        newIl.setCreateDate(new Date(0));
        iller.add(newIl);
        return new ResponseEntity<>(newIl,HttpStatus.CREATED);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        Il il=getIlById(id);
        iller.remove(il);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> getIl(@PathVariable String id,@RequestBody Il newIl){
        Il oldIl=getIlById(id);
        oldIl.setName(newIl.getName());
        oldIl.setCreateDate(new Date(0));
        return new ResponseEntity<>(HttpStatus.OK);

    }

    private Il getIlById(String id){
        return iller.stream()
        .filter(il -> il.getId().equals(id))
        .findFirst()
        .orElseThrow(()->new RuntimeException("IL not found "));

    }
}
