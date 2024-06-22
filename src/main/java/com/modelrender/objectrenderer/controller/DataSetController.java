package com.modelrender.objectrenderer.controller;

import com.modelrender.objectrenderer.dto.DataSetDTO;
import com.modelrender.objectrenderer.entity.DataSet;
import com.modelrender.objectrenderer.entity.Query;
import com.modelrender.objectrenderer.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataset")
public class DataSetController {

    @Autowired
    private DataSetService dataSetService;

    @GetMapping("/getByName/{name}")
    public DataSet getDataSetByName(@PathVariable String name)
    {
        return dataSetService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<DataSet> getAllDataSet()
    {
        return dataSetService.findAllDataSet();
    }

    @PostMapping("/insertDataSet")
    public DataSet insertDataSet(@RequestBody DataSet dataSet)
    {
        return dataSetService.insertDataSet(dataSet);
    }

    @PostMapping("/getDataSetDTO")
    public DataSetDTO getDataSetDTO(@RequestBody List<Query> queries)
    {
        return dataSetService.getDataSetDTO(queries);
    }
}
