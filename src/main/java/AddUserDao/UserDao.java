package AddUserDao;

import Exceptions.UserException;
import UserImplementation.Implementation.ReturnState;
import UserImplementation.Implementation.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDao {

    public static List<User> userList;

    public UserDao() {
        userList = new ArrayList<>();
    }

    public static ReturnState addUser(User user) {
        System.out.println(user);
        userList.add(user);
        return ReturnState.SUCCESS;
    }

    public static List<User> listUsers(){
        return userList;
    }

    public boolean UserExistance(User user) {
        return userList.contains(user);
    }

    public User getUserFromId(String id) throws UserException {
        User retval = null;
        for (User user : userList) {
            if (user.getId() == Long.parseLong(id)) {
                retval = user;
            }
        }

        if (retval == null) {
            throw new UserException("User does not exist",UserException.UserExceptionCode.USER_UPDATE_ERROR);
        }
        return retval;
    }
}
