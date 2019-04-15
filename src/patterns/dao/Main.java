package patterns.dao;

public class Main {
    public static void main(String[] args) {
        User user = new User("qwe",45);
        UserDao userDao = new TxtFileUserDao();
        userDao.addUser(user);
    }
}
