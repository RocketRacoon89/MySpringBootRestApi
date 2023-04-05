package com.mike.spring.springboot.springboot_rest.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Events")
public class Event {

    public Event() {
    }

    @Id
    @ManyToOne
    private Users user;

    @ManyToOne
    private File file;

    @Column(name = "status")
    private String status;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
