package com.anuz.cdsserver.dao;

import com.anuz.cdsserver.model.Client;

public interface ClientDAO extends  GenericDAO<Client>{

    Boolean getContentUpdateStatus(int clientId);

}
