package patterns.dao;

import homework5.task1.List;

public interface UserDao {
    void addUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);

}
