package com.mike.spring.springboot.springboot_rest.security;

import com.mike.spring.springboot.springboot_rest.entity.User;
import com.mike.spring.springboot.springboot_rest.security.jwt.JwtUser;
import com.mike.spring.springboot.springboot_rest.security.jwt.JwtUserFactory;
import com.mike.spring.springboot.springboot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);

        if(user==null) {
            throw new UsernameNotFoundException("User not found "+username);
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
