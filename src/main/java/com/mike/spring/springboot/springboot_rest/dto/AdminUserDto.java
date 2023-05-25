package com.mike.spring.springboot.springboot_rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {

    private int id;
    private String username;
    private String email;

    public UserEntity toUser(){
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(username);
        user.setEmail(email);
        return user;
    }

    public static AdminUserDto fromUser(UserEntity user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getName());
        adminUserDto.setEmail(user.getEmail());
        return adminUserDto;
    }
}
