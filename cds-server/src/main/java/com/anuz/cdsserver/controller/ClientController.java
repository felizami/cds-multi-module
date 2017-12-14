package com.anuz.cdsserver.controller;

import com.anuz.cdsserver.model.Client;
import com.anuz.cdsserver.model.ContentUpdateStatus;
import com.anuz.cdsserver.service.ClientService;
import com.anuz.cdsserver.service.ContentService;
import com.anuz.cdsserver.service.ContentUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/users")
public class ClientController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ClientService clientService;
    @Autowired
    private ContentUpdateService contentUpdateService;
    @Autowired
    private ContentService contentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> allClients() {
        logger.info("Retreive all Users");
        logger.debug("show this");
        return clientService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client findOne(@PathVariable("id") int id) {
        return clientService.getById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody Client client) {
        return clientService.saveOrUpdate(client);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ResponseEntity delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return ResponseEntity.ok(id);
    }


    @RequestMapping(value="/{userId}/contents")
    public ResponseEntity contentsByUserId(@PathVariable("userId") int userId){
        List<ContentUpdateStatus> contentsByuserId=contentUpdateService.getByClientId(userId);
        return new ResponseEntity(contentsByuserId, HttpStatus.OK);
    }


    @RequestMapping(value = "/{userId}/html/latest",method = RequestMethod.GET)
    public ResponseEntity contentChildUpdate(@PathVariable("userId") int userId){
        ContentUpdateStatus update=contentUpdateService.getLatestHTMLContentByClientId(userId);
        return new ResponseEntity(update,HttpStatus.OK);
    }


    @RequestMapping(value = "/content_status/{clientId}", method = RequestMethod.GET)
    public ModelMap contentUpdate(@PathVariable("clientId") int clientId) {

        ModelMap map = new ModelMap();

        map.addAttribute("contents", contentUpdateService.getByClientId(clientId));
        return map;

    }

    @RequestMapping(value = "/test/{userId}", method = RequestMethod.GET)
    public ModelMap check(@PathVariable("userId") int userId) {

        ModelMap map = new ModelMap();

        map.addAttribute("test", contentUpdateService.getUnsynchronizedContentList(userId));
        return map;

    }
}
