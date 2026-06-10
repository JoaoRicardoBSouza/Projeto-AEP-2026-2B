package com.aep2.demo.services;

import com.aep2.demo.models.PostagemModel;
import com.aep2.demo.models.UserModel;
import com.aep2.demo.repositories.PostagemRepository;
import com.aep2.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UserRepository userRepository;

    public PostagemModel criarPostagem(Long userId, PostagemModel postagem) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        postagem.setUser(user);
        return postagemRepository.save(postagem);
    }

    public List<PostagemModel> listarTodas() {
        return postagemRepository.findAll();
    }

    public List<PostagemModel> listarPorUsuario(Long userId) {
        return postagemRepository.findByUserId(userId);
    }

    public PostagemModel buscarPorTitulo(String titulo) {
        return postagemRepository.findByTitulo(titulo);
    }

    public void deletar(Long id) {
        postagemRepository.deleteById(id);
    }
}