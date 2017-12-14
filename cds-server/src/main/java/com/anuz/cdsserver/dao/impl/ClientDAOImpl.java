/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.cdsserver.dao.impl;

import com.anuz.cdsserver.dao.ClientDAO;
import com.anuz.cdsserver.model.Client;
import com.anuz.cdsserver.service.ContentUpdateService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    ContentUpdateService userContentService;

    @Override
    public List<Client> getAll() {
        List<Client> user;
        try (Session session = sessionFactory.openSession()) {
            user = session.createQuery("SELECT u FROM Client u").list();
        }
        return user;
    }

    @Override
    public Client getById(int id) {
        Client customerById;
        try (Session session = sessionFactory.openSession()) {
            customerById = (Client) session.get(Client.class, id);
        }
        return customerById;
    }

    @Override
    public int saveOrUpdate(Client user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(user);

            transaction.commit();
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete((Client) session.get(Client.class, id));
            transaction.commit();
        }
        return 1;
    }

    
    @Override
    public Boolean getContentUpdateStatus(int userId) {

        Session session = sessionFactory.openSession();
        Boolean status = (Boolean) session.createQuery("Select uc.status from UserContent uc where uc.userId.userId=:userId").setParameter("userId", userId).uniqueResult();
        return status;
    }

    
}
