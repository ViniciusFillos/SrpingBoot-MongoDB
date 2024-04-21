package com.vinifillos.workshopmongo.services;

import com.vinifillos.workshopmongo.domain.User;
import com.vinifillos.workshopmongo.dto.UserDTO;
import com.vinifillos.workshopmongo.repository.UserRespository;
import com.vinifillos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<User> findAll() {
        return userRespository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRespository.findById(id);
        if(user.isPresent()) return user.get();
        else throw new ObjectNotFoundException("Objeto não encontrado");
    }

    public User insert(User user) {
        return userRespository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
