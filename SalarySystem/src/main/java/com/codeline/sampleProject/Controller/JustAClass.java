package com.codeline.sampleProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/general/getStringSample
@RestController
//@RequestMapping(value = "general")
public class JustAClass {

    @RequestMapping(path = "getStringSample")
    public String getStringSample() /*throws Exception*/ {
//        throw new Exception("Error");
        return "Hello";
    }
}
