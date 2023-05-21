package com.mike.spring.springboot.springboot_rest.rest;

import com.mike.spring.springboot.springboot_rest.dto.AuthenticationRequestDto;
import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import com.mike.spring.springboot.springboot_rest.security.jwt.JwtTokenProvider;
import com.mike.spring.springboot.springboot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    private UserService userService;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping(value = "login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            System.out.println("ATTENTION TEST ResponseEntity");  //FOR TEST
            String username = requestDto.getUsername();

            System.out.println("ATTENTION TEST username= "+username+ "requestDto.getPassword()  "+requestDto.getPassword());  //FOR TEST

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));

            System.out.println("test test test "+authenticationManager.toString());  //FOR TEST

            UserEntity user = userService.findByUsername(username);

            System.out.println("ATTENTION TEST user= "+user.toString());  //FOR TEST

            if(user == null) {
                throw new UsernameNotFoundException("User with username: "+ username + " not found!");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            System.out.println("ATTENTION TEST token= "+token);  //FOR TEST

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password "+e);
        }

    }
}
