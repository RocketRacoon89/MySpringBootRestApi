package com.mike.spring.springboot.springboot_rest.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<EventEntity> events;

    @ManyToMany
    @JoinTable(name = "user_roles",
    joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")})
    private List<RoleEntity> roles;

    @Column(name = "status")
    private Status status;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;
}
