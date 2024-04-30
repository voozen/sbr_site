package tech.grypsiarze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tech.grypsiarze.model.DoctorStructure;
import tech.grypsiarze.repository.Doctor;
import tech.grypsiarze.repository.User;
import tech.grypsiarze.model.UserStructure;

import java.util.List;

@RestController
public class FirstController {
    
    @Autowired
    User theUser;

    @Autowired
    Doctor theDoctor;

    @GetMapping("/")
    public List<UserStructure> start(){
        return theUser.showAllUsers();
    }

    @PostMapping("/user/register")
    public String register(@RequestBody UserStructure userData){
        return theUser.save(userData);
    }

    @GetMapping("/searchDoctor")
    public List<DoctorStructure> search(@RequestParam(value = "cat",required = false) String cat,
                                        @RequestParam(value = "cit",required = false) String cit){
        if (cat==null) cat="%";
        if (cit == null) cit ="%";
        return theDoctor.findDoctors(cat,cit);
    }
}
