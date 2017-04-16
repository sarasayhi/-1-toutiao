package com.marissaman.service;

import com.marissaman.dao.NewsDAO;
import com.marissaman.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saras on 2017/4/16.
 */
@Service
public class NewsService {
    @Autowired
    private NewsDAO newsDAO;

    public List<News> getLatesNews(int userId, int offset, int limit){
        return newsDAO.selectByUserIdAndOffset(userId,offset,limit);
    }
}
