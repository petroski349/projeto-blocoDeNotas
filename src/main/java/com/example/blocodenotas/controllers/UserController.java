package com.example.blocodenotas.controllers;

import com.example.blocodenotas.controllers.security.JWTTokenProvider;
import com.example.blocodenotas.models.entitys.User;
import com.example.blocodenotas.models.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/user/")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PutMapping(value = "update-user/{userId}")
    public ResponseEntity<Object> update(@RequestHeader String Authorization, @RequestBody User user) {
        Long userId = JWTTokenProvider.getAllClaimsFromToken(Authorization).get("userId", Long.class);
        User userAux = userRepository.findById(userId);
        if(!userRepository.existsById(userId))
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
    public ResponseEntity<Object> get(@RequestHeader String Authorization) {
        Long userId = JWTTokenProvider.getAllClaimsFromToken(Authorization).get("userId", Long.class);
        User user = userRepository.findById(userId);
        if(user == null)
            return ResponseEntity.badRequest().body("usuário não encontrado");
        return ResponseEntity.ok(user);
    }
    @DeleteMapping(value = "delete-user/{userId}")
    public ResponseEntity<Object> delete(@RequestHeader String Authorization) {
        Long userId = JWTTokenProvider.getAllClaimsFromToken(Authorization).get("userId", Long.class);
        User user = userRepository.findById(userId);
        if(userRepository.existsById(userId)){
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
