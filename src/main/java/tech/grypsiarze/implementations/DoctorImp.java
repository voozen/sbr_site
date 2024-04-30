package tech.grypsiarze.implementations;

import tech.grypsiarze.model.DoctorStructure;

import java.util.List;

public interface DoctorImp {
    public List<DoctorStructure> findDoctors(String category, String city);
}
