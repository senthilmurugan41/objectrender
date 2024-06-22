package com.modelrender.objectrenderer.service.impl;

import com.modelrender.objectrenderer.entity.Insertion;
import com.modelrender.objectrenderer.repo.InsertionRepo;
import com.modelrender.objectrenderer.service.InsertionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertionServiceImpl implements InsertionService {
    @Autowired
    private InsertionRepo insertionRepo;

    @Override
    public Insertion addInsertion(Insertion insertion) {
        return insertionRepo.save(insertion);
    }

    @Override
    public List<Insertion> findAllInsertion() {
        return insertionRepo.findAll();
    }

    @Override
    public Insertion findInsertionByName(String name) {
        return insertionRepo.findByName(name);
    }

    @Override
    public Insertion updateInsertionName(String oldName, String newName) {
        Insertion insertion = insertionRepo.findByName(oldName);
        insertion.setName(newName);
        return insertionRepo.save(insertion);
    }

    @Override
    public void deleteInsertionByName(String name) {
        insertionRepo.delete(insertionRepo.findByName(name));
    }
}
