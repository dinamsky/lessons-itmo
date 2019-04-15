package patterns.dao;

import homework5.task1.List;

public class TxtFileUserDao implements UserDao {
    @Override
    public void addUser(User user) {
        System.out.println("Add user" + user);
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
