package com.modelrender.objectrenderer.service;

import com.modelrender.objectrenderer.entity.Insertion;

import java.util.List;

public interface InsertionService {
    Insertion addInsertion(Insertion insertion);

    List<Insertion> findAllInsertion();

    Insertion findInsertionByName(String name);

    Insertion updateInsertionName(String oldName, String newName);

    void deleteInsertionByName(String name);

}
