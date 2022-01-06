package com.sid.tutorials.spring.module03.jdbc.callbacks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.tutorials.spring.module03.jdbc.callbacks.dao.EmployeeDao;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("Employees List");
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employees Average Salary Calculated Row by Row");
        System.out.println(employeeDao.findAverageSalaryRowByRow());

        System.out.println("Employees Average Salary Calculated on Entire Result Set");
        System.out.println(employeeDao.findAverageSalaryCalculatedOnEntireResultSet());

        System.out.println("Employees Average Salary with streams");
        System.out.println(employeeDao.findAverageSalaryModernImplementation());

        System.out.println("Employees Average Salary sql level");
        System.out.println(employeeDao.findAverageSalarySqlLevel());

        System.out.println("Employee found based on email");
        System.out.println(employeeDao.findEmployeeIdFromEmail("Jayvon.Grant@corp.com"));

        System.out.println("Employee Report Stop");
    }
}