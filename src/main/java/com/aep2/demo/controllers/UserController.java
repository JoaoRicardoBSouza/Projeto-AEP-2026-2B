package com.aep2.demo.controllers;

import com.aep2.demo.models.PostagemModel;
import com.aep2.demo.models.UserModel;
import com.aep2.demo.repositories.PostagemRepository;
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

    @Autowired
    private PostagemRepository postagemRepository;

    @PostMapping
    public ResponseEntity<UserModel> criarUser(@RequestBody UserModel userModel){
        UserModel criado = userService.criarUser(userModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(criado.getId()).toUri();
        return ResponseEntity.created(uri).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> listarTudo(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> atualizarUser(@PathVariable Long id, @RequestBody UserModel userModel){
        return ResponseEntity.ok().body(userService.updateUser(id, userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUser(@PathVariable Long id){
        userService.deletarUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/postagens/{titulo}")
    public ResponseEntity<Optional<PostagemModel>> buscarPorTitulo(@PathVariable String titulo){
        PostagemModel postagem = postagemRepository.findByTitulo(titulo);
        return ResponseEntity.ok().body(Optional.ofNullable(postagem));
    }
}
