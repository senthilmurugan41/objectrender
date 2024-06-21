package com.modelrender.objectrenderer.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;

public class ESUtil {

    public static Supplier<Query> createSupplierAutoSuggest(String partialQueryName)
    {
        Supplier<Query> supplier = () -> Query.of(q->q.match(createAutoSuggestMatchQuery(partialQueryName)));
        return supplier;
    }

    public static MatchQuery createAutoSuggestMatchQuery(String partialQueryName)
    {
        val autoSuggestQuery = new MatchQuery.Builder();
        return autoSuggestQuery.field("name").query(partialQueryName).analyzer("standard").build();
    }
}
