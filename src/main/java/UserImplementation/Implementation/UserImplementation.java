package UserImplementation.Implementation;

import AddUserDao.UserDao;

public class UserImplementation {

    UserDao userDao;

    /**
     * Constructor for User Implementation
     */
    public UserImplementation() {
        userDao = new UserDao();
    }

    public User addUser(long id, String name , String lastName, String password) throws Exception {
        User user = new User(name, lastName, password, id);
        if (checkExistance(user)) {
            throw new Exception("shiiiit, User exists");
        } else {
            userDao.addUser(user);
            System.out.println(user.toString() + "\n User successfully added");
        }
        return user;
    }

    private boolean checkExistance(User user) {
        //TODO add dao
        return userDao.UserExistance(user);
    }
}
