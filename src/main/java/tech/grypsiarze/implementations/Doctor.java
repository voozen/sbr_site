package tech.grypsiarze.implementations;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.grypsiarze.model.DoctorStructure;

public interface Doctor extends JpaRepository<DoctorStructure, Integer>, DoctorFunctions {
}
