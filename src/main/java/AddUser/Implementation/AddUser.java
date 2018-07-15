package AddUser.Implementation;

import AddUserDao.UserDao;

public class AddUser {

    private long id;
    private User user;
    private String addUserState;

    public AddUser() {
    }

    public void addUser(long id, String name , String lastName, String password) throws Exception {
        user = new User(name, lastName, password, id);
        if (checkExistance(user)) {
            throw new Exception("shiiiit");
        } else {
            UserDao.saveUser(user);
            addUserState= ReturnState.SUCCESS.getState();
            System.out.println(addUserState);

        }
    }

    private boolean checkExistance(User user) {
        //TODO add dao
        return false;
    }

    public String resultState() {
        return addUserState;
    }
}
