package com.github.pabloo99.entity;

import com.github.pabloo99.dao.EmployeeDao;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;


@Data
@NoArgsConstructor
public class Department {

    private Integer departmentId;
    private String departmentName;
    private Integer menagerId;
    private Integer locationId;

}
