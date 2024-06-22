package com.modelrender.objectrenderer.repo;

import com.modelrender.objectrenderer.entity.Insertion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsertionRepo extends JpaRepository<Insertion, Integer> {

    Insertion findByName(String name);
}
