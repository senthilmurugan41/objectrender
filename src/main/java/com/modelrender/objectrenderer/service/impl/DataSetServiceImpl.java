package com.modelrender.objectrenderer.service.impl;


import com.modelrender.objectrenderer.dto.DataSetDTO;
import com.modelrender.objectrenderer.entity.*;
import com.modelrender.objectrenderer.repo.CourseRepo;
import com.modelrender.objectrenderer.repo.DataSetRepo;
import com.modelrender.objectrenderer.repo.InsertionRepo;
import com.modelrender.objectrenderer.repo.OriginRepo;
import com.modelrender.objectrenderer.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSetServiceImpl implements DataSetService {

    @Autowired
    private DataSetRepo dataSetRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private OriginRepo originRepo;

    @Autowired
    private InsertionRepo insertionRepo;

    @Override
    public DataSet findByName(String name) {
        return dataSetRepo.findByName(name);
    }

    @Override
    public DataSet insertDataSet(DataSet dataSet) {
        dataSet.getCourses()
                .forEach(course -> course.setDataSet(dataSet));

        dataSet.getInsertions()
                .forEach(insertion -> insertion.setDataSet(dataSet));

        dataSet.getOrigins()
                .forEach(origin -> origin.setDataSet(dataSet));

        return dataSetRepo.save(dataSet);
    }

    @Override
    public List<DataSet> findAllDataSet() {
        return dataSetRepo.findAll();
    }

    @Override
    public DataSetDTO getDataSetDTO(List<Query> queries) {
        DataSetDTO dataSetDTO = new DataSetDTO();

        if (queries.isEmpty()) {
            return null;
        }

        Query query = queries.get(0);

        if (query.isMuscle()) {
            DataSet dataSet = dataSetRepo.findByName(query.getMuscleName());
            dataSetDTO.getMuscles().add(dataSet.getName());

            dataSet.getCourses().stream()
                    .map(Course::getName)
                    .forEach(dataSetDTO.getCourses()::add);

            dataSet.getInsertions().stream()
                    .map(Insertion::getName)
                    .forEach(dataSetDTO.getIntersections()::add);

            dataSet.getOrigins().stream()
                    .map(Origin::getName)
                    .forEach(dataSetDTO.getOrigins()::add);
        } else {
            if (query.isCourse()) {
                Course course = courseRepo.findByName(query.getName());
                if (course != null) {
                    dataSetDTO.getCourses().add(course.getName());
                }
            } else if (query.isInsertion()) {
                Insertion insertion = insertionRepo.findByName(query.getName());
                if (insertion != null) {
                    dataSetDTO.getIntersections().add(insertion.getName());
                }
            } else if (query.isOrigin()) {
                Origin origin = originRepo.findByName(query.getName());
                if (origin != null) {
                    dataSetDTO.getOrigins().add(origin.getName());
                }
            }
        }

        return dataSetDTO;
    }
}
