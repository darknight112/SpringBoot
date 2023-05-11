package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    public void createEmployee() {

        Employee employee = new Employee();
        employee.setName("Abdullah");
        employee.setGender("Male");
        employee.setSalary(650.0);
        employee.setDepartment("IT");
        employee.setCompanyName("TechM");
        employee.setCreatedDate(new Date());
        employee.setIsActive(true);
        employeeService.saveEmployee(employee);
    }
}
