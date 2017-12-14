/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.cdsserver.dao.impl;


import com.anuz.cdsserver.dao.ContentDAO;
import com.anuz.cdsserver.model.Content;
import com.anuz.cdsserver.service.ContentUpdateService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ContentDAOImpl implements ContentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    ContentUpdateService userContentService;

    @Override
    public List<Content> getAll() {
        List<Content> content;
        try (Session session = sessionFactory.openSession()) {
            content = session.createQuery("SELECT u FROM Content u").list();
        }
        return content;
    }

    @Override
    public Content getById(int id) {
        Content contentById;
        try (Session session = sessionFactory.openSession()) {
            contentById = (Content) session.get(Content.class, id);
        }
        return contentById;
    }

    @Override
    public int saveOrUpdate(Content t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(t);

            transaction.commit();
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete((Content) session.get(Content.class, id));
            transaction.commit();
        }
        return 1;
    }

   
}
