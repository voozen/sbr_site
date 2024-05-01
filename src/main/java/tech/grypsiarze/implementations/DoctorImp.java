package tech.grypsiarze.implementations;

import java.util.List;
import tech.grypsiarze.model.AddressStructure;
import tech.grypsiarze.model.DoctorStructure;
import tech.grypsiarze.repository.Doctor;

public interface DoctorImp {
  public List<DoctorStructure> findDoctors(String category, String city);
  public String saveDoctor(AddressStructure theAddress,
                           DoctorStructure theDoctor);
}
