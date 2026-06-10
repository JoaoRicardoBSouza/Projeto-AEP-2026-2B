package com.aep2.demo.controllers;

import com.aep2.demo.models.PostagemModel;
import com.aep2.demo.services.PostagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/postagens")
@Tag(name = "Postagens", description = "Endpoints de postagens")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @PostMapping("/usuario/{userId}")
    @Operation(summary = "Cria uma postagem vinculada a um usuário")
    public ResponseEntity<PostagemModel> criar(
            @PathVariable Long userId,
            @RequestBody PostagemModel postagem) {

        PostagemModel criada = postagemService.criarPostagem(userId, postagem);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(criada.getId()).toUri();
        return ResponseEntity.created(uri).body(criada);
    }

    @GetMapping
    @Operation(summary = "Lista todas as postagens")
    public ResponseEntity<List<PostagemModel>> listarTodas() {
        return ResponseEntity.ok(postagemService.listarTodas());
    }

    @GetMapping("/usuario/{userId}")
    @Operation(summary = "Lista postagens de um usuário específico")
    public ResponseEntity<List<PostagemModel>> listarPorUsuario(@PathVariable Long userId) {
        return ResponseEntity.ok(postagemService.listarPorUsuario(userId));
    }

    @GetMapping("/titulo/{titulo}")
    @Operation(summary = "Busca postagem por título")
    public ResponseEntity<PostagemModel> buscarPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(postagemService.buscarPorTitulo(titulo));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma postagem")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        postagemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
