package com.anuz.cdsserver.service;

import com.anuz.cdsserver.dao.ContentUpdateDAO;
import com.anuz.cdsserver.model.Content;
import com.anuz.cdsserver.model.ContentUpdateStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentUpdateService {
    @Autowired
    ContentUpdateDAO contentUpdateDAO;
            
    
    public List<ContentUpdateStatus> getAll() {
        return contentUpdateDAO.getAll();
    }

    public ContentUpdateStatus getById(int id) {
        return contentUpdateDAO.getById(id);
    }

    public int saveOrUpdate(ContentUpdateStatus user) {
        return contentUpdateDAO.saveOrUpdate(user);
    }

    public int delete(int id) {
        return contentUpdateDAO.delete(id);
    }
    
    public List<ContentUpdateStatus> getByClientId(int clientId){
        return contentUpdateDAO.getByClientId(clientId);
    }
    public List<Content> getUnsynchronizedContentList(int clientId){
        return contentUpdateDAO.getUnsynchronizedContentList(clientId);
    }

    public int updateContentStatus(int clientId,Boolean status){
        return contentUpdateDAO.updateContentStatus(clientId, status);
    }
    
    
     public ContentUpdateStatus getLatestHTMLContentByClientId(int clientId){
         return contentUpdateDAO.getLatestHTMLContentByClientId(clientId);
     }
    
    

    
}
