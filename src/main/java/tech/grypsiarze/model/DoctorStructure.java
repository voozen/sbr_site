package tech.grypsiarze.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "doctor")
public class DoctorStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorID")
    private int doctorID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "addressID")
    private int addressID;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "category")
    private String category;
}
