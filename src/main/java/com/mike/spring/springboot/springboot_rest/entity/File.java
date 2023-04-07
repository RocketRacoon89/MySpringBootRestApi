package com.mike.spring.springboot.springboot_rest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {

    public File() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="location")
    private String location;

    @Column(name="status")
    private String status;

    public File(String location, String status) {
        this.location = location;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", status=" + status +
                '}';
    }
}
