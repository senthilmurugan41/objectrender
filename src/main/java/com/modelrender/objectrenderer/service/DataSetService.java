package com.modelrender.objectrenderer.service;

import com.modelrender.objectrenderer.dto.DataSetDTO;
import com.modelrender.objectrenderer.entity.DataSet;
import com.modelrender.objectrenderer.entity.Query;

import java.util.List;

public interface DataSetService {
    DataSet findByName(String name);

    DataSet insertDataSet(DataSet dataSet);

    List<DataSet> findAllDataSet();

    DataSetDTO getDataSetDTO(List<Query> query);
}
