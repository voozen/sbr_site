package tech.grypsiarze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.grypsiarze.implementations.Doctor;
import tech.grypsiarze.implementations.UserImp;
import tech.grypsiarze.model.AddressDoctorDto;
import tech.grypsiarze.model.AddressStructure;
import tech.grypsiarze.model.DoctorStructure;
import tech.grypsiarze.model.UserStructure;

import java.util.List;

@RestController
public class FirstController {
    
    @Autowired
    UserImp theUser;

    @Autowired
    Doctor theDoctor;

    @GetMapping("/")
    public String start(){
        return "Grypsiarze backend working fine!";
    }
    @GetMapping("/users/showall")
    public List<UserStructure> showAllUsers(){
        return theUser.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserStructure userData) {
        try {
            theUser.save(userData);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
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
