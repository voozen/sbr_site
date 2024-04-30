package tech.grypsiarze.implementations;

import tech.grypsiarze.model.UserStructure;

import java.util.List;

public interface UserImp {
    public String save(UserStructure theUser);
    public List<UserStructure> showAllUsers();
}
