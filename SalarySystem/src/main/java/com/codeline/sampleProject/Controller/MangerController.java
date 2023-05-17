package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Models.Manager;
import com.codeline.sampleProject.Service.EmployeeService;
import com.codeline.sampleProject.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MangerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("manager/create")
    public void saveManager(){
    }


    public void createManager() {


    }
}
