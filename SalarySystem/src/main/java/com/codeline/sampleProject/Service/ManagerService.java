package com.codeline.sampleProject.Service;


import com.codeline.sampleProject.Models.Manager;
import com.codeline.sampleProject.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;
    public void saveManager(Manager manager){
        managerRepository.save(manager);
    }

}
