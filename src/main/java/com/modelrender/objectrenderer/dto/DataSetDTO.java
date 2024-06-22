package com.modelrender.objectrenderer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSetDTO {
//    muscles: string[] = [];
//    origins: string[] = [];
//    intersections: string[] = [];
//    courses: string[] = [];
//    nerves: string[] = [];

    private List<String> muscles = new ArrayList<>();
    private List<String> origins = new ArrayList<>();
    private List<String> intersections = new ArrayList<>();
    private List<String> courses = new ArrayList<>();


}
