package com.mike.spring.springboot.springboot_rest.security;

import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import com.mike.spring.springboot.springboot_rest.repository.UserRepository;
import com.mike.spring.springboot.springboot_rest.security.jwt.JwtUser;
import com.mike.spring.springboot.springboot_rest.security.jwt.JwtUserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByName(name);

        if(user==null) {
            throw new UsernameNotFoundException("User not found "+name+" MY EX");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
