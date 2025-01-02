package com.example.blocodenotas.controllers;

import com.example.blocodenotas.controllers.security.JWTTokenProvider;
import com.example.blocodenotas.models.entitys.LoginRequest;
import com.example.blocodenotas.models.entitys.User;
import com.example.blocodenotas.models.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "access/")
public class accessController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @PostMapping(value = "login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        com.example.blocodenotas.models.entitys.User user = null;
        user = userRepository.findByEmail(loginRequest.getEmail());
        if(user == null)
            return ResponseEntity.badRequest().body("email não encontrado");
        if( !user.getPassword().equals(loginRequest.getPassword())){
            return ResponseEntity.badRequest().body("não cadastrado");
        }
        return ResponseEntity.ok(jwtTokenProvider.makeToken(user.getId(),user.getName()));
    }

    @PostMapping(value = "register")
    public ResponseEntity<Object> add(@RequestBody User user) {
        if(userRepository.findByEmail(user.getEmail()) == null){
            user = new User(user.getName(), user.getPassword(), user.getEmail(), LocalDateTime.now());
            System.out.println(user.getCreationDate());
            try {
                user = userRepository.save(user);
                return ResponseEntity.ok(user);
            }catch (Exception e) {
                return ResponseEntity.badRequest().body("ERRO");
            }
        }
        return ResponseEntity.badRequest().body("email ja cadastrado");
    }
}