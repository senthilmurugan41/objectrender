package com.modelrender.objectrenderer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "query")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {

    @Id
    private int id;

    private String name;

    private String muscleName;

    private boolean muscle;

    private boolean origin;

    private boolean insertion;

    private boolean course;
}
