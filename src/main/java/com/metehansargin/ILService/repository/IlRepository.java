package com.metehansargin.ILService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.metehansargin.ILService.model.Il;

public interface IlRepository extends MongoRepository<Il,String> {

}