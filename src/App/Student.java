package App;

import java.util.HashMap;

public class Student{
    private String institute;//学院
    private String specialized;//专业
    private String number;//学号
    private String name;//姓名
    private String squad;//年级班级
    private String age;//年龄
    private String gender;//性别
    private String phoneNumber;//联系方式
    private String politicalLandscape;//政治面貌
    private HashMap<String, String> hm;//所选课程
    public Student() {
    }

    public Student(String institute, String specialized, String number, String name, String squad, String age, String gender, String phoneNumber, String politicalLandscape, HashMap<String, String> hm) {
        this.institute = institute;
        this.specialized = specialized;
        this.number = number;
        this.name = name;
        this.squad = squad;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.politicalLandscape = politicalLandscape;
        this.hm = hm;
    }

    /**
     * 获取
     * @return institute
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * 设置
     * @param institute
     */
    public void setInstitute(String institute) {
        this.institute = institute;
    }

    /**
     * 获取
     * @return specialized
     */
    public String getSpecialized() {
        return specialized;
    }

    /**
     * 设置
     * @param specialized
     */
    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    /**
     * 获取
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
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
     * @return squad
     */
    public String getSquad() {
        return squad;
    }

    /**
     * 设置
     * @param squad
     */
    public void setSquad(String squad) {
        this.squad = squad;
    }

    /**
     * 获取
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return politicalLandscape
     */
    public String getPoliticalLandscape() {
        return politicalLandscape;
    }

    /**
     * 设置
     * @param politicalLandscape
     */
    public void setPoliticalLandscape(String politicalLandscape) {
        this.politicalLandscape = politicalLandscape;
    }

    /**
     * 获取
     * @return hm
     */
    public HashMap<String, String> getHm() {
        return hm;
    }

    /**
     * 设置
     * @param hm
     */
    public void setHm(HashMap<String, String> hm) {
        this.hm = hm;
    }

    public String toString() {
        return "Student{institute = " + institute + ", specialized = " + specialized + ", number = " + number + ", name = " + name + ", squad = " + squad + ", age = " + age + ", gender = " + gender + ", phoneNumber = " + phoneNumber + ", politicalLandscape = " + politicalLandscape + ", hm = " + hm + "}";
    }
}
