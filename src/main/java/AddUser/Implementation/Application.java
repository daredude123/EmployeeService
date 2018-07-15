package AddUser.Implementation;

import AddUserDao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //load Users

        UserDao userDao = new UserDao();

        int count = userDao.loadUsers();
        System.out.printf("Users loaded %d",count);

        SpringApplication.run(Application.class, args);
    }
}
