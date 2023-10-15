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
    public List<User> getUsers(@RequestParam(required = false) Integer limit) {
        if (limit == null) {
            return userService.getUsers();
        }
        return userService.getUsers().subList(0, limit);
    }

    @GetMapping({"{productId}", "{productId}/"})
    public ResponseEntity<Object> getSingleProduct(@PathVariable("productId") Long id) {
        return this.userService.getSingleUser(id);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return this.userService.newUser(user);
    }

    @PutMapping({"/", ""})
    public ResponseEntity<Object> updateProduct(@RequestBody User user) {
        return this.userService.newUser(user);
    }

    @DeleteMapping({"{productId}", "{productId}/"})
    public  ResponseEntity<Object> delete(@PathVariable("productId") Long id) {
        return this.userService.deleteUser(id);
    }
}
