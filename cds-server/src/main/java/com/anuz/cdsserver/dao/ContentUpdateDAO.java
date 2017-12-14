package com.anuz.cdsserver.dao;

import com.anuz.cdsserver.model.Content;
import com.anuz.cdsserver.model.ContentUpdateStatus;

import java.util.List;

public interface ContentUpdateDAO extends GenericDAO<ContentUpdateStatus>{

    List<ContentUpdateStatus> getByClientId(int clientId);

    List<Content> getUnsynchronizedContentList(int clientId);
    int updateContentStatus(int ClientId, Boolean status);

    ContentUpdateStatus getLatestHTMLContentByClientId(int clientId);

}