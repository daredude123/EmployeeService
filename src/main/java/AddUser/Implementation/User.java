package AddUser.Implementation;

import java.io.Serializable;

public class User implements Serializable {

    String name,lastName,password;

    long id;

    public User(String name, String lastName, String password, long id) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
