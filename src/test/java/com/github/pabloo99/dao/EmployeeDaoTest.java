package com.github.pabloo99.dao;

import com.github.pabloo99.entity.Employee;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;

class EmployeeDaoTest {

    @Test
    void shouldAddAndRemoveEmployee(){
        EmployeeDao employeeDaoTest = new EmployeeDao();

        Employee result = new Employee();
        result.setEmployeeId(500);
        result.setFirstName("Mateusz");
        result.setLastName("Marczak");
        result.setEmail("Marczak@gmail.com");
        result.setPhoneNumber("999.999.999");
        result.setHireDate(Date.valueOf(LocalDate.now()));
        result.setJobId("IT_PROG");
        result.setSalary(50000.00);
        result.setManagerId(100);
        result.setDepartmentId(110);
        employeeDaoTest.add(result);

        Employee employee = employeeDaoTest.findByID(500);
        assertTrue(employee.getFirstName().equals("Mateusz"));

        employeeDaoTest.deleteById(500);
        assertNull(employeeDaoTest.findByID(500));

    }

    @Test
    void shouldReturnEmployeeById(){
        EmployeeDao employeeDaoTest = new EmployeeDao();
        Employee employee = employeeDaoTest.findByID(100);
        assertTrue(employee.getFirstName().equals("Steven"));
    }

    @Test
    void shouldReturnALlEmplyees(){
        EmployeeDao employeeDaoTest = new EmployeeDao();
        List<Employee> employeeList = employeeDaoTest.findAll();
        assertTrue(employeeList.size() > 0);
    }

}