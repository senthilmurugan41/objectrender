package com.modelrender.objectrenderer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="course")
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
