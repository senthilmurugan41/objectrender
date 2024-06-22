package com.modelrender.objectrenderer.controller;

import com.modelrender.objectrenderer.entity.Course;
import com.modelrender.objectrenderer.entity.Origin;
import com.modelrender.objectrenderer.service.CourseService;
import com.modelrender.objectrenderer.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/origin")
public class OriginController {

    @Autowired
    private OriginService originService;

    @PostMapping("/insertOrigin")
    public Origin insertOrigin(@RequestBody Origin origin) {
        return originService.addOrigin(origin);
    }

    @GetMapping("/getAllOrigin")
    public List<Origin> getOrigins() {
        return originService.findAllOrigin();
    }

    @GetMapping("/getByName/{name}")
    public Origin getOriginByName(@PathVariable String name) {
        return originService.findOriginByName(name);
    }

    @PutMapping("/updateByName/{oldName}/{newName}")
    public Origin updateOriginByName(@PathVariable String oldName, @PathVariable String newName) {
        return originService.updateOriginName(oldName, newName);
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteOriginByName(@PathVariable String name) {
        originService.deleteOriginByName(name);
    }

}
