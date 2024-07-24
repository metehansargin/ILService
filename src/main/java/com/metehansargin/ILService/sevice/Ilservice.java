package com.metehansargin.ILService.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metehansargin.ILService.model.Il;
import com.metehansargin.ILService.repository.IlRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Ilservice {
    private final IlRepository ilRepository;

    public List<Il> getIller() {
        return ilRepository.findAll();
    }

    public Il createIl(Il newIl) {
        return ilRepository.save(newIl);
        
    }

    public void deleteIl(String id) {
    ilRepository.deleteById(id);
    
    }

    public void updateIl(String id, Il newIl) {
    Il oldIl=getIlById(id);
    oldIl.setName(newIl.getName());
    ilRepository.save(oldIl);

    }

    public Il getIlById(String id) {
    return ilRepository.findById(id)
    .orElseThrow(()->new RuntimeException("Il not found "));
    }

}
