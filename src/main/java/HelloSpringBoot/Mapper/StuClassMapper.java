package HelloSpringBoot.Mapper;

import HelloSpringBoot.domain.StuClass;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StuClassMapper extends BaseMapper<StuClass> {
    @Select("select classname from stu_class")
    public List<StuClass> findallClass();


}
