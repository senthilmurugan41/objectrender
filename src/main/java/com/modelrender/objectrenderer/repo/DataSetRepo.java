package com.modelrender.objectrenderer.repo;

import com.modelrender.objectrenderer.entity.DataSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSetRepo extends JpaRepository<DataSet,Integer> {
    DataSet findByName(String name);
}
