package com.metehansargin.ILService.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Il {
@Id
private String id;
private Date createDate=new Date(0);
private String name;
}
