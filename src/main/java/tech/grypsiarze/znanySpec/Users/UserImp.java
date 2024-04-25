package tech.grypsiarze.znanySpec.Users;

import java.util.List;

public interface UserImp {
    public String save(UserStructure theUser);
    public List<UserStructure> showAllUsers();
}
