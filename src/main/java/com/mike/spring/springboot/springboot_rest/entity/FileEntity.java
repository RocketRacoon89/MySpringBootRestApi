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
    private Status location;

    @Column(name="status")
    private Status status;

    public FileEntity(Status location, Status status) {
        this.location = location;
        this.status = status;
    }

}
