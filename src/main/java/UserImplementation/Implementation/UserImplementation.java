package UserImplementation.Implementation;

import AddUserDao.UserDao;

public class UserImplementation {

    private long id;
    private User user;
    private String addUserState;
    UserDao userDao;

    /**
     * Constructor for User Implementation
     */
    public UserImplementation() {
        userDao = new UserDao();
    }

    public void addUser(long id, String name , String lastName, String password) throws Exception {
        user = new User(name, lastName, password, id);
        if (checkExistance(user)) {
            throw new Exception("shiiiit, User exists");
        } else {
            userDao.addUser(user);
            addUserState= ReturnState.SUCCESS.getState();
            System.out.println(addUserState);

        }
    }

    private boolean checkExistance(User user) {
        //TODO add dao
        return userDao.UserExistance(user);
    }

    public String resultState() {
        return addUserState;
    }
}
