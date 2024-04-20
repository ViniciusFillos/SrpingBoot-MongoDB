package com.vinifillos.workshopmongo.services;

import com.vinifillos.workshopmongo.domain.User;
import com.vinifillos.workshopmongo.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<User> findAll() {
        return userRespository.findAll();
    }
}
