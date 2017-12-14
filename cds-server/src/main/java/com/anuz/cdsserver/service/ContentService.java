package com.anuz.cdsserver.service;

import com.anuz.cdsserver.dao.ContentDAO;
import com.anuz.cdsserver.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    @Autowired
    ContentDAO contentDAO;
    
    public List<Content> getAll() {
        return contentDAO.getAll();
    }

    public Content getById(int id) {
        return contentDAO.getById(id);
    }

    public int saveOrUpdate(Content content) {
        return contentDAO.saveOrUpdate(content);
    }

    public int delete(int id) {
        return contentDAO.delete(id);
    }
    
    
    
}
