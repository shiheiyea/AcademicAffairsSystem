package App;

import java.util.Objects;
import java.util.SplittableRandom;

public class Curriculum {
    private String TeacherName;//任课老师名字
    private String number;//课程编号
    private String name;//课程名称
    private String CourseCategory;//课程类别
    private String TotalHours;//总学时
    private String TheoreticalHours;//理论学时
    private String LabHours;//实验学时
    private String Credits;//学分
    private String StartOfTheSemester;//开学学期
    private String ExamDate;//考试日期
    private String ExamTime;//考试时间
    private String TestLocation;//考试地点
    private String ExamLength;//考试时长

    public Curriculum() {
    }

    public Curriculum(String TeacherName, String number, String name, String CourseCategory, String TotalHours, String TheoreticalHours, String LabHours, String Credits, String StartOfTheSemester, String ExamDate, String ExamTime, String TestLocation, String ExamLength) {
        this.TeacherName = TeacherName;
        this.number = number;
        this.name = name;
        this.CourseCategory = CourseCategory;
        this.TotalHours = TotalHours;
        this.TheoreticalHours = TheoreticalHours;
        this.LabHours = LabHours;
        this.Credits = Credits;
        this.StartOfTheSemester = StartOfTheSemester;
        this.ExamDate = ExamDate;
        this.ExamTime = ExamTime;
        this.TestLocation = TestLocation;
        this.ExamLength = ExamLength;
    }

    /**
     * 获取
     * @return TeacherName
     */
    public String getTeacherName() {
        return TeacherName;
    }

    /**
     * 设置
     * @param TeacherName
     */
    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
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
     * @return CourseCategory
     */
    public String getCourseCategory() {
        return CourseCategory;
    }

    /**
     * 设置
     * @param CourseCategory
     */
    public void setCourseCategory(String CourseCategory) {
        this.CourseCategory = CourseCategory;
    }

    /**
     * 获取
     * @return TotalHours
     */
    public String getTotalHours() {
        return TotalHours;
    }

    /**
     * 设置
     * @param TotalHours
     */
    public void setTotalHours(String TotalHours) {
        this.TotalHours = TotalHours;
    }

    /**
     * 获取
     * @return TheoreticalHours
     */
    public String getTheoreticalHours() {
        return TheoreticalHours;
    }

    /**
     * 设置
     * @param TheoreticalHours
     */
    public void setTheoreticalHours(String TheoreticalHours) {
        this.TheoreticalHours = TheoreticalHours;
    }

    /**
     * 获取
     * @return LabHours
     */
    public String getLabHours() {
        return LabHours;
    }

    /**
     * 设置
     * @param LabHours
     */
    public void setLabHours(String LabHours) {
        this.LabHours = LabHours;
    }

    /**
     * 获取
     * @return Credits
     */
    public String getCredits() {
        return Credits;
    }

    /**
     * 设置
     * @param Credits
     */
    public void setCredits(String Credits) {
        this.Credits = Credits;
    }

    /**
     * 获取
     * @return StartOfTheSemester
     */
    public String getStartOfTheSemester() {
        return StartOfTheSemester;
    }

    /**
     * 设置
     * @param StartOfTheSemester
     */
    public void setStartOfTheSemester(String StartOfTheSemester) {
        this.StartOfTheSemester = StartOfTheSemester;
    }

    /**
     * 获取
     * @return ExamDate
     */
    public String getExamDate() {
        return ExamDate;
    }

    /**
     * 设置
     * @param ExamDate
     */
    public void setExamDate(String ExamDate) {
        this.ExamDate = ExamDate;
    }

    /**
     * 获取
     * @return ExamTime
     */
    public String getExamTime() {
        return ExamTime;
    }

    /**
     * 设置
     * @param ExamTime
     */
    public void setExamTime(String ExamTime) {
        this.ExamTime = ExamTime;
    }

    /**
     * 获取
     * @return TestLocation
     */
    public String getTestLocation() {
        return TestLocation;
    }

    /**
     * 设置
     * @param TestLocation
     */
    public void setTestLocation(String TestLocation) {
        this.TestLocation = TestLocation;
    }

    /**
     * 获取
     * @return ExamLength
     */
    public String getExamLength() {
        return ExamLength;
    }

    /**
     * 设置
     * @param ExamLength
     */
    public void setExamLength(String ExamLength) {
        this.ExamLength = ExamLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curriculum that = (Curriculum) o;
        return Objects.equals(TeacherName, that.TeacherName) && Objects.equals(number, that.number) && Objects.equals(name, that.name) && Objects.equals(CourseCategory, that.CourseCategory) && Objects.equals(TotalHours, that.TotalHours) && Objects.equals(TheoreticalHours, that.TheoreticalHours) && Objects.equals(LabHours, that.LabHours) && Objects.equals(Credits, that.Credits) && Objects.equals(StartOfTheSemester, that.StartOfTheSemester) && Objects.equals(ExamDate, that.ExamDate) && Objects.equals(ExamTime, that.ExamTime) && Objects.equals(TestLocation, that.TestLocation) && Objects.equals(ExamLength, that.ExamLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TeacherName, number, name, CourseCategory, TotalHours, TheoreticalHours, LabHours, Credits, StartOfTheSemester, ExamDate, ExamTime, TestLocation, ExamLength);
    }

    public String toString() {
        return "Curriculum{TeacherName = " + TeacherName + ", number = " + number + ", name = " + name + ", CourseCategory = " + CourseCategory + ", TotalHours = " + TotalHours + ", TheoreticalHours = " + TheoreticalHours + ", LabHours = " + LabHours + ", Credits = " + Credits + ", StartOfTheSemester = " + StartOfTheSemester + ", ExamDate = " + ExamDate + ", ExamTime = " + ExamTime + ", TestLocation = " + TestLocation + ", ExamLength = " + ExamLength + "}";
    }
}
