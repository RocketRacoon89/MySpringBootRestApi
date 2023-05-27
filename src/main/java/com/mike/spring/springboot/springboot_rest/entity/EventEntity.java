package com.mike.spring.springboot.springboot_rest.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "events")
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "user_id")
//    private int user_id;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "file_id")
//    private FileEntity file;

    @OneToOne
    @JoinColumn(name = "file_id")
    private FileEntity file;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
