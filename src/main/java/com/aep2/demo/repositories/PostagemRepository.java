package com.aep2.demo.repositories;

import com.aep2.demo.models.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {
    PostagemModel findByTitulo(String titulo);
    List<PostagemModel> findByUserId(Long userId);
}
