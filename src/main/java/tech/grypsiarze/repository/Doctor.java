package tech.grypsiarze.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.grypsiarze.implementations.DoctorImp;
import tech.grypsiarze.model.DoctorStructure;

import java.util.List;
@Repository
public class Doctor implements DoctorImp {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<DoctorStructure> findDoctors(String category, String city) {
        return entityManager.createQuery("SELECT d FROM DoctorStructure d WHERE d.city LIKE :cit AND d.category LIKE :cat")
                .setParameter("cit", city)
                .setParameter("cat", category)
                .getResultList();
    }
}