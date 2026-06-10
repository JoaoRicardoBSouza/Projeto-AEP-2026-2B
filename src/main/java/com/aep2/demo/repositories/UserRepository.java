package com.aep2.demo.repositories;

import com.aep2.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    public UserModel findByTitulo(String titulo);
}
