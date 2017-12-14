package com.anuz.cdsserver.service;


import com.anuz.cdsserver.dao.ClientDAO;
import com.anuz.cdsserver.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public List<Client> getAll() {
        return clientDAO.getAll();
    }

    public Client getById(int id) {
        return clientDAO.getById(id);
    }

    public int saveOrUpdate(Client user) {
        return clientDAO.saveOrUpdate(user);
    }

    public int delete(int id) {
        return clientDAO.delete(id);
    }

}
