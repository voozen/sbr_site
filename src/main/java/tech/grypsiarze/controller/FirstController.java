package tech.grypsiarze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.grypsiarze.users.User;
import tech.grypsiarze.users.UserStructure;

import java.util.List;

@RestController
public class FirstController {
    @Autowired
    User theUser;


    @GetMapping("/")
    public List<UserStructure> start(){
        return theUser.showAllUsers();
    }

    @PostMapping("/user/register")
    public String register(@RequestBody UserStructure userData){
        return theUser.save(userData);
    }
}
