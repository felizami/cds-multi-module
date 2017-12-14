package com.anuz.cdsclient.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    public ModelMap htmtUpdates(String url){

        RestTemplate restTemplate =new RestTemplate();
        ModelMap map=restTemplate.getForObject(url, ModelMap.class);
        return map;
    }

}

