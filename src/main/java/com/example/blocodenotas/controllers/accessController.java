package com.example.blocodenotas.controllers;

import com.example.blocodenotas.models.entitys.LoginRequest;
import com.example.blocodenotas.models.entitys.User;
import com.example.blocodenotas.models.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping(value = "access/")
public class accessController {
    @Autowired
    UserRepository userRepository;

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

    @PostMapping(value = "login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        User user = null;
        user = userRepository.findByEmail(loginRequest.getEmail());
        if(user == null)
            return ResponseEntity.badRequest().body("email não encontrado");
        if( !user.getPassword().equals(loginRequest.getPassword())){
            return ResponseEntity.badRequest().body("não cadastrado");
        }
        return ResponseEntity.ok(user);
    }
    @PutMapping(value = "update-user/{userId}")
    public ResponseEntity<Object> update(@PathVariable Long userId,@RequestBody User user) {
        User userAux = userRepository.findById(userId);
        if(userAux == null)
            return ResponseEntity.badRequest().body("usuario não encontrado");

        if(user.getName() != null)
            userAux.setName(user.getName());
        if(user.getEmail() != null)
            userAux.setEmail(user.getEmail());
        if(user.getPassword() != null)
            userAux.setPassword(user.getPassword());
        try{
            userRepository.save(userAux);
            return ResponseEntity.ok(userAux);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO-> "+e.getMessage());
        }
    }
    @GetMapping(value = "get/{userId}")
    public ResponseEntity<Object> get(@PathVariable Long userId) {
        User user = userRepository.findById(userId);
        if(user == null)
            return ResponseEntity.badRequest().body("usuário não encontrado");
        return ResponseEntity.ok(user);
    }
    @DeleteMapping(value = "delete-user/{userId}")
    public ResponseEntity<Object> delete(@PathVariable Long userId) {
        User user = userRepository.findById(userId);
        if(user != null){
            try {
                userRepository.delete(user);
                return ResponseEntity.ok("deletado");
            }catch (Exception e) {return ResponseEntity.badRequest().body("ERRO");}
        }
        else {
            return ResponseEntity.badRequest().body("Não encontrado");
        }
    }
}