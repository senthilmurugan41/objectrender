package com.modelrender.objectrenderer.controller;


import com.modelrender.objectrenderer.entity.Insertion;
import com.modelrender.objectrenderer.service.InsertionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insertion")
public class InsertionController {

    @Autowired
    private InsertionService insertionService;

    @PostMapping("/insertInsertion")
    public Insertion insertCourse(@RequestBody Insertion insertion) {
        return insertionService.addInsertion(insertion);
    }

    @GetMapping("/getAllInsertion")
    public List<Insertion> getInsertions() {
        return insertionService.findAllInsertion();
    }

    @GetMapping("/getByName/{name}")
    public Insertion getInsertionByName(@PathVariable String name) {
        return insertionService.findInsertionByName(name);
    }

    @PutMapping("/updateByName/{oldName}/{newName}")
    public Insertion updateCourseByName(@PathVariable String oldName, @PathVariable String newName) {
        return insertionService.updateInsertionName(oldName, newName);
    }

    @DeleteMapping("/deleteByName/{name}")
    public void deleteInsertionByName(@PathVariable String name) {
        insertionService.deleteInsertionByName(name);
    }

}
