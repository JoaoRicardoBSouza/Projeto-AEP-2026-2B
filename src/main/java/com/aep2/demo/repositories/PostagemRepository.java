package com.aep2.demo.repositories;

import com.aep2.demo.models.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {
    PostagemModel findByTitulo(String titulo);
}
