package com.anuz.cdsserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/server")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public String defaultController(){
        return "Module:Server";
    }
}
