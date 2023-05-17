package com.mike.spring.springboot.springboot_rest.entity;


import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "events")
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @JsonBackReference
//    @ManyToOne
//    private User user;

    @Column(name = "user_id")
    private int user_id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileEntity file;

    @Column(name = "status")
    private Status status;
}
