package tech.grypsiarze.znanySpec.Users;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class User implements UserImp{
    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public String save(UserStructure theUser) {
        try {
            entityManager.persist(theUser);
            return "Saved!";
        } catch (Exception error){
            return String.format("Error: %s",error);
        }
    }
}
