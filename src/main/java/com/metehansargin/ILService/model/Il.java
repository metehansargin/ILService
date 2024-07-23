package com.metehansargin.ILService.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Il {
private Date createDate;
private String id;
private String name;
}
