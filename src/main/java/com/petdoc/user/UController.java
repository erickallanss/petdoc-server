package com.petdoc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UController {

    @Autowired
    private UService service;

    @GetMapping
    public List<UUser> getAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{id}")
    public UUser getUserById(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @PostMapping
    public UUser createUser(@RequestBody UUser user) {
        return service.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
