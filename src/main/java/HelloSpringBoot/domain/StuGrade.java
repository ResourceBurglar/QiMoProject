package HelloSpringBoot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "stu_grade")
public class StuGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stuname;
    private Integer yuwen;
    private Integer math;
    private Integer english;
    private Integer average;
    private Integer allgrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getYuwen() {
        return yuwen;
    }

    public void setYuwen(int yuwen) {
        this.yuwen = yuwen;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getAllgrade() {
        return allgrade;
    }

    public void setAllgrade(int allgrade) {
        this.allgrade = allgrade;
    }

    @Override
    public String toString() {
        return "StuGrade{" +
                "id=" + id +
                ", stuname='" + stuname + '\'' +
                ", yuwen=" + yuwen +
                ", math=" + math +
                ", english=" + english +
                ", average=" + average +
                ", allgrade=" + allgrade +
                '}';
    }
}
