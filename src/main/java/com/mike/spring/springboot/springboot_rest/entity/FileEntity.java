package com.mike.spring.springboot.springboot_rest.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "files")
@Data
public class FileEntity {

    public FileEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="location")
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;


}
