package HelloSpringBoot.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "stu_grade")
public class StuGrade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String stuname;
    private String classname;
    private Integer yuwen;
    private Integer math;
    private Integer english;
    private Integer average;
    private Integer allgrade;
    private Integer classid;

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

    public Integer getYuwen() {
        return yuwen;
    }

    public void setYuwen(Integer yuwen) {
        this.yuwen = yuwen;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Integer getAllgrade() {
        return allgrade;
    }

    public void setAllgrade(Integer allgrade) {
        this.allgrade = allgrade;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }


    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void countSum() {
        this.allgrade = this.yuwen + this.math + this.english;
    }

    public void countAver() {
        this.average = this.allgrade / 3;
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
