package tech.grypsiarze.implementations;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.grypsiarze.model.UserStructure;

import java.util.List;

public interface UserImp extends JpaRepository<UserStructure, Integer> {
}
