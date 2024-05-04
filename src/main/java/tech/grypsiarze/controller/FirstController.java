package tech.grypsiarze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tech.grypsiarze.model.AddressDoctorDto;
import tech.grypsiarze.model.AddressStructure;
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
    public String start(){
        return "Grypsiarze backend working fine!";
    }
    @GetMapping("/users/showall")
    public List<UserStructure> showAllUsers(){
        return theUser.showAllUsers();
    }

    @PostMapping("/register")
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
    @PostMapping("/saveDoctor")
    public String doctorSave(@RequestBody AddressDoctorDto request){
        AddressStructure addressData = request.getAddressData();
        DoctorStructure doctorData = request.getDoctorData();
        return theDoctor.saveDoctor(addressData,doctorData);
    }
}
