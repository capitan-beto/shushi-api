package com.capitanbeto.sushi.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return this.userService.newUser(user);
    }
}
