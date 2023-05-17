package com.mike.spring.springboot.springboot_rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
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

    public static UserDto fromUser(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
