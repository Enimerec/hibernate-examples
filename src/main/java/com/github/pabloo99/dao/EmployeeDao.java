package com.github.pabloo99.dao;

import com.github.pabloo99.entity.Employee;

public class EmployeeDao extends HibernateDao<Employee> {

    public EmployeeDao() {
        super(Employee.class);
    }

}
