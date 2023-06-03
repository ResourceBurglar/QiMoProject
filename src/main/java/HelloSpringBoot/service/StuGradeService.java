package HelloSpringBoot.service;

import HelloSpringBoot.domain.StuGrade;
import HelloSpringBoot.vo.StuGradeQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface StuGradeService extends IService<StuGrade> {
    List<StuGrade> getAllGrade();

    IPage<StuGrade> getGradeByPage(IPage<StuGrade> page, StuGradeQueryVo stuGradeQueryVo);
    int insertGrades(List<StuGrade> list);
}
