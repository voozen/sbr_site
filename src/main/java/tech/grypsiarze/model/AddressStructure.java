package tech.grypsiarze.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "address")
public class AddressStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressID")
    private int addressID;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "country")
    private String country;
}
