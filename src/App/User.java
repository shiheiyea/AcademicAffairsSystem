package App;

import java.security.Principal;
import java.util.Objects;

public class User {
    private String name;
    private String password;
    private Student stu;
    private String Photo;

    public User() {
    }

    public User(String name, String password, Student stu, String Photo) {
        this.name = name;
        this.password = password;
        this.stu = stu;
        this.Photo = Photo;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return stu
     */
    public Student getStu() {
        return stu;
    }

    /**
     * 设置
     * @param stu
     */
    public void setStu(Student stu) {
        this.stu = stu;
    }

    /**
     * 获取
     * @return Photo
     */
    public String getPhoto() {
        return Photo;
    }

    /**
     * 设置
     * @param Photo
     */
    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String toString() {
        return "User{name = " + name + ", password = " + password + ", stu = " + stu + ", Photo = " + Photo + "}";
    }
}
