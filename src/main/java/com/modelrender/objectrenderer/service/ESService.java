package com.modelrender.objectrenderer.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.modelrender.objectrenderer.entity.Query;
import com.modelrender.objectrenderer.util.ESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

@Service
public class ESService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<Query> autoSuggestQuery(String  partialQueryName) throws IOException {
       Supplier<co.elastic.clients.elasticsearch._types.query_dsl.Query> supplier = ESUtil.createSupplierAutoSuggest(partialQueryName);
       return elasticsearchClient
               .search(s->s.index("query").query(supplier.get()),Query.class);
    }
}
