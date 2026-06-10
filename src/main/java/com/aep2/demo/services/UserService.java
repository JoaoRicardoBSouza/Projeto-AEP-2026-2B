package com.aep2.demo.services;

import com.aep2.demo.models.UserModel;
import com.aep2.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserModel criarUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    public void deletarUser(Long id){
        userRepository.deleteById(id);
    }

    public UserModel updateUser(Long id, UserModel userModel){
        UserModel model = userRepository.save(userModel);

        model.setEmail(userModel.getEmail());
        model.setSenha(userModel.getSenha());
        model.setUserEnum(userModel.getUserEnum());

        return userRepository.save(model);
    }

    public UserModel findByTitulo(String titulo){
        return userRepository.findByTitulo(titulo);
    }
}
