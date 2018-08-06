package AddUserDao;

import AddUser.Implementation.ReturnState;
import AddUser.Implementation.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDao {

    public static List<User> userList;


    public static ReturnState saveUser(User user) {
        System.out.println(user);
        UUID uuid = new UUID(1l,1l);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/Resources/Users/Employee"+uuid.toString()+".user");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ReturnState.FAILED;
        } catch (IOException e) {
            e.printStackTrace();
            return ReturnState.FAILED;
        }
        return ReturnState.SUCCESS;

    }


    public int loadUsers() {
        File folder = new File("/home/andreas/javaproject/EmployeeService/Resources/Users");
        System.out.println(folder.getAbsolutePath());
        File[] listOfFiles = folder.listFiles();
        System.out.println();

        userList = new ArrayList<>();
        if (listOfFiles != null) {
            for (File x : listOfFiles) {
                System.out.println(x);
                try {
                    FileInputStream fileInputStream = new FileInputStream(x);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    userList.add((User) objectInputStream.readObject());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return userList.size();
    }
}
