package com.anuz.cdsclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public String clientController(){
        return "Module: Client";
    }
}
