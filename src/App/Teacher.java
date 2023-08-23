package App;

import java.util.HashMap;

public class Teacher {
    private String name;//名字
    private String institute;//学院
    private String specialized;//专业
    private HashMap<String, String> hm;//所教课程

    public Teacher() {
    }

    public Teacher(String name, String institute, String specialized, HashMap<String, String> hm) {
        this.name = name;
        this.institute = institute;
        this.specialized = specialized;
        this.hm = hm;
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
        return "Teacher{name = " + name + ", institute = " + institute + ", specialized = " + specialized + ", hm = " + hm + "}";
    }
}
