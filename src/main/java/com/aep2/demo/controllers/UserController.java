package com.aep2.demo.controllers;

import com.aep2.demo.models.UserModel;
import com.aep2.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> criarPostagem(@RequestBody UserModel userModel){
        UserModel criarPostagem = userService.criarUser(userModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userModel.getId()).toUri();

        return ResponseEntity.created(uri).body(userModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserModel>> listarTudo(){
        List<UserModel> userModelList = userService.findAll();

        return ResponseEntity.ok().body(userModelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> listarPorId(@PathVariable Long id){
        Optional<UserModel> userModelOptional = userService.findById(id);

        return ResponseEntity.ok().body(userModelOptional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> atualizarPostagem(@PathVariable Long id, @RequestBody UserModel userModel){
        UserModel model = userService.updateUser(id, userModel);

        return ResponseEntity.ok().body(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable Long id){
        userService.deletarUser(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/postagens/{titulo}")
    public ResponseEntity<Optional<UserModel>> buscarTitulo(@PathVariable String titulo){
        UserModel userModel = userService.findByTitulo(titulo);

        return ResponseEntity.ok().body(Optional.ofNullable(userModel));
    }
}
