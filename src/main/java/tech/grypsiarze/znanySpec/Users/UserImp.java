package tech.grypsiarze.znanySpec.users;

import java.util.List;

public interface UserImp {
    public String save(UserStructure theUser);
    public List<UserStructure> showAllUsers();
}
