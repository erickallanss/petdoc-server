package com.petdoc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UService {

    @Autowired
    private URepository repository;

    public List<UUser> findAllUsers() {
        return repository.findAll();
    }

    public UUser findUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UUser createUser(UUser user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
    public UUser findUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}
