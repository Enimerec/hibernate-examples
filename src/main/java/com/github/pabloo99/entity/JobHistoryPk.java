package com.github.pabloo99.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
public class JobHistoryPk implements Serializable {

    private Integer employeeId;
    private Date startDate;


}
