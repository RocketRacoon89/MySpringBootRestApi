package com.mike.spring.springboot.springboot_rest.security.jwt;

import com.mike.spring.springboot.springboot_rest.entity.Role;
import com.mike.spring.springboot.springboot_rest.entity.Status;
import com.mike.spring.springboot.springboot_rest.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create (User user) {
        return new JwtUser(user.getId(), user.getName(), user.getPassword(), user.getStatus().equals(Status.ACTIVE), mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
