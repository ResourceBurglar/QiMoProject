package HelloSpringBoot.Mapper;

import HelloSpringBoot.domain.StuGrade;
import HelloSpringBoot.vo.StuGradeQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;


public interface StuGradeMapper extends BaseMapper<StuGrade> {

    @Select("select * from stu_class as sc join stu_grade as sg on sc.id = sg.classid")
    public List<StuGrade>getAllGrade();


    // 分页
    IPage<StuGrade> getGradeByPage(@Param("page") IPage<StuGrade> page, @Param("stuGrade")StuGradeQueryVo stuGradeQueryVo);

    int insertGrades(@Param("list") List<StuGrade> list);
}
