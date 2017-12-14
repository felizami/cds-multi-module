package com.anuz.cdsclient.controller.api;

import com.anuz.cdsclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/html_update/{clientId}",method = RequestMethod.GET)
    public ResponseEntity getHTMLUpdates(@PathVariable("clientId") int clientId){
        System.out.println("Check");
        String url="http://localhost:8282/api/v1/users/"+clientId+"/html/latest";
        ModelMap map=new ModelMap();
        map.addAttribute("updates", clientService.htmtUpdates(url));
        return new ResponseEntity(map, HttpStatus.OK);

    }
}
