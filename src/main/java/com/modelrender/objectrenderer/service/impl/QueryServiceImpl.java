package com.modelrender.objectrenderer.service.impl;

import com.modelrender.objectrenderer.entity.Query;
import com.modelrender.objectrenderer.repo.QueryRepo;
import com.modelrender.objectrenderer.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {

   @Autowired
   private  QueryRepo queryRepo;

    @Override
    public Query insertQuery(Query query) {
        return queryRepo.save(query);
    }
;
    @Override
    public Iterable<Query> getQuery() {
        return queryRepo.findAll();
    }
}
