package com.modelrender.objectrenderer.service.impl;


import com.modelrender.objectrenderer.entity.Origin;
import com.modelrender.objectrenderer.repo.OriginRepo;
import com.modelrender.objectrenderer.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginServiceImpl implements OriginService {
    @Autowired
    private OriginRepo originRepo;

    @Override
    public Origin addOrigin(Origin origin) {
        return originRepo.save(origin);
    }

    @Override
    public List<Origin> findAllOrigin() {
        return originRepo.findAll();
    }

    @Override
    public Origin findOriginByName(String name) {
        return originRepo.findByName(name);
    }

    @Override
    public Origin updateOriginName(String oldName, String newName) {
        Origin origin = originRepo.findByName(oldName);
        origin.setName(newName);
        return originRepo.save(origin);
    }

    @Override
    public void deleteOriginByName(String name) {
        originRepo.delete(originRepo.findByName(name));
    }
}
