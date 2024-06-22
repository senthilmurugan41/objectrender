package com.modelrender.objectrenderer.repo;

import com.modelrender.objectrenderer.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginRepo extends JpaRepository<Origin, Integer> {

    Origin findByName(String name);
}
