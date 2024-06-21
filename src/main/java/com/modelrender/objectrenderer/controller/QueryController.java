package com.modelrender.objectrenderer.controller;


import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.modelrender.objectrenderer.entity.Query;
import com.modelrender.objectrenderer.service.ESService;
import com.modelrender.objectrenderer.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @Autowired
    private ESService esService;

    @GetMapping("/all")
    Iterable<Query> getAllQuery(){
        return queryService.getQuery();
    }

    @PostMapping("/insertQuery")
    Query insertQuery(@RequestBody Query query)
    {
        return queryService.insertQuery(query);
    }

    @GetMapping("/autoSuggest")
    List<String> autoSuggestQuerySearch(@RequestParam String partialQuery) throws IOException {
        SearchResponse<Query> querySearchResponse = esService.autoSuggestQuery(partialQuery);
        List<Hit<Query>> hitList = querySearchResponse.hits().hits();
        List<Query> queryList = new ArrayList<>();
        for(Hit<Query> hit: hitList)
        {
            queryList.add(hit.source());
        }
        List<String> listOfQuery = new ArrayList<>();
        for(Query q:queryList)
        {
            listOfQuery.add(q.getName());
        }
        return listOfQuery;
    }

}
