package tech.grypsiarze.znanySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.grypsiarze.znanySpec.Users.User;
import tech.grypsiarze.znanySpec.Users.UserStructure;

@RestController
public class FirstController {
    @Autowired
    User theUser;


    @GetMapping("/")
    public String start(){
        return "Hi! :)";
    }

    @PostMapping("/user/register")
    public String register(@RequestBody UserStructure userData){
        return theUser.save(userData);
    }
}
