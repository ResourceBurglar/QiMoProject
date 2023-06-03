package HelloSpringBoot.Mapper;

import HelloSpringBoot.domain.StuClass;
import HelloSpringBoot.domain.StuGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StuGradeMapper {

    @Select("select * from stu_class as sc join stu_grade as sg on sc.id = sg.classid")
    public List<StuGrade>getAllGrade();

}
