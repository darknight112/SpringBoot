package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Manager;
import com.codeline.sampleProject.RequestObjects.GetManagerRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetManagerResponse;
import com.codeline.sampleProject.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MangerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("manager/create")
    public void saveManager (@RequestBody GetManagerRequestObject managerRequestObject) {
        createManager(managerRequestObject);
    }

    @RequestMapping("manager/get")
    public List<Manager> getManager () {
        return managerService.getManager();
    }

    //Path Variable
    @RequestMapping("manager/get/{managerId}")
    public GetManagerResponse createManager (@PathVariable Long managerId) {
        return managerService.getManagerById(managerId);
    }

    public void createManager(GetManagerRequestObject managerRequestObject) {

        Manager manager = new Manager();
        manager.setDepartment(managerRequestObject.getDepartment());
        manager.setTeamName("The Moon");
        manager.setCreatedDate(new Date());
        manager.setIsActive(true);
        managerService.saveManager(manager);
    }
}
