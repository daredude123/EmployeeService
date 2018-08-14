package UserImplementation.Implementation;

import AddUserDao.UserDao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableAutoConfiguration
public class UserController {

    private static final String template = "Hello, %s!";
    UserImplementation userImpl = new UserImplementation();
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/GetUsers")
    public List<User> listUsers(){
        return UserDao.userList;
    }

    @RequestMapping("/UserImplementation")
    public String AddUser(@RequestParam(value = "name") String name,
                       @RequestParam(value="lastName") String lastName,
                       @RequestParam(value="password") String password) throws Exception {

        System.out.println("Enter AddUser");
        System.out.println(name+":"+lastName+":"+password);
        if (name == null) {
            throw new Exception("First name, Last name, and password must be present.");
        }
        userImpl.addUser(counter.incrementAndGet(), name, lastName, password);
        return userImpl.resultState();
    }

    @RequestMapping("/AddUserTest")
    public String AddUserTest(@RequestParam(value = "yeye", defaultValue = "success") String yeye) {

        return "Success";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new String(counter.incrementAndGet()+" "+
                String.format(template, name));
    }
}