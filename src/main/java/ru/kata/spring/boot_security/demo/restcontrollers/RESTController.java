package ru.kata.spring.boot_security.demo.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public RESTController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> createNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
        userService.userDelete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
