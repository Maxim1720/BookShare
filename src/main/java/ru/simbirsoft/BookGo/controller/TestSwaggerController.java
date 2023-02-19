package ru.simbirsoft.BookGo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.BookGo.entity.User;
import ru.simbirsoft.BookGo.repository.UserRepository;
import ru.simbirsoft.BookGo.security.UserResponded;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/swagger-test")
public class TestSwaggerController {
    public final UserRepository userRepository;

    @Autowired
    public TestSwaggerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponded> getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(new UserResponded().map(user), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserResponded>> getAllUsers() {
        List<UserResponded> users = userRepository
                .findAll().stream()
                .map(user -> new UserResponded().map(user))
                .collect(Collectors.toList());

        return users.isEmpty() ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/user/new")
    public ResponseEntity<UserResponded> addUser(@RequestBody User user){
        userRepository.save(user);
        return userRepository.findUserByEmail(user.getEmail()).orElse(null) == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(new UserResponded().map(user), HttpStatus.OK);
    }
}
