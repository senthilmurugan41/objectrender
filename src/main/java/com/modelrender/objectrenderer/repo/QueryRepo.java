package com.modelrender.objectrenderer.repo;

import com.modelrender.objectrenderer.entity.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface QueryRepo extends ElasticsearchRepository<Query, Integer> {
}
