package tech.grypsiarze.implementations;

import tech.grypsiarze.model.AddressStructure;
import tech.grypsiarze.model.DoctorStructure;

import java.util.List;

public interface DoctorFunctions {
    public List<DoctorStructure> findDoctors(String category, String city);
    public String saveDoctor(AddressStructure theAddress, DoctorStructure theDoctor);
}
