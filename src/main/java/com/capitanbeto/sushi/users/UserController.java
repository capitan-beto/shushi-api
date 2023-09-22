package com.capitanbeto.sushi.users;

import com.capitanbeto.sushi.product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<User> getUsers() {
        return usersService.getUsers();
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return this.usersService.newUser(user);
    }
}
