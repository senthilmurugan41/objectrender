package com.modelrender.objectrenderer.service;

import com.modelrender.objectrenderer.entity.Query;

public interface QueryService {
    Query insertQuery(Query query);

    Iterable<Query> getQuery();
}
