package com.github.pabloo99.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDaoTest {

    @Test
    public void shouldReturnEmployeeCount(){
        DepartmentDao departmentDao = new DepartmentDao();
        int count = departmentDao.countEmployeesByDepartmentId(60);
        assertEquals(count, 5);
    }

}