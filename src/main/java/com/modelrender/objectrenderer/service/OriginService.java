package com.modelrender.objectrenderer.service;

import com.modelrender.objectrenderer.entity.Course;
import com.modelrender.objectrenderer.entity.Origin;

import java.util.List;

public interface OriginService {
    Origin addOrigin(Origin origin);

    List<Origin> findAllOrigin();

    Origin findOriginByName(String name);

    Origin updateOriginName(String oldName, String newName);

    void deleteOriginByName(String name);

}
