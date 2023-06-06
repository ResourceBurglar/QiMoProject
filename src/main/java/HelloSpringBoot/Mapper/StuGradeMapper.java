package HelloSpringBoot.Mapper;

import HelloSpringBoot.domain.StuGrade;
import HelloSpringBoot.vo.StuGradeQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.*;


import java.util.List;


public interface StuGradeMapper extends BaseMapper<StuGrade> {

    @Select("SELECT sg.id, sc.classname, sg.stuname,sg.yuwen, sg.math, sg.english, " +
            "sg.average, sg.allgrade FROM stu_grade as sg LEFT JOIN stu_class as sc on sg.classname = sc.classname")
    public List<StuGrade>getAllGrade();


    // 分页
    IPage<StuGrade> getGradeByPage(@Param("page") IPage<StuGrade> page, @Param("stuGrade")StuGradeQueryVo stuGradeQueryVo);

    int insertGrades(@Param("list") List<StuGrade> list);


    @Delete("delete from stu_grade where id = #{id}")
    void deleteGradeById(@Param("id") Integer id);

    @Insert("insert into stu_grade(stuname)values(#{stuname})")
    public void addStuButNoClass(String stuname);



    @Select("select id,stuname from stu_grade as sg where  sg.classname ='' or sg.classname is null")
    public List<StuGrade>NotClassStu();


    @Update("update stu_grade set classname = #{classname} where id = #{id}")
    public int distributeClass(@Param("classname")String name,@Param("id")Integer id);





}
