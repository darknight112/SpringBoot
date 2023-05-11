package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("employee/create")
    public void saveEmployee(){
        createEmployee();
    }

    @RequestMapping("employee/get")
    public List<Employee> getEmployee () {
        return employeeService.getEmployee();
    }



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
