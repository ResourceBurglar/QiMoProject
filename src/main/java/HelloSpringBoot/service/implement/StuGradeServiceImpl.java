package HelloSpringBoot.service.implement;

import HelloSpringBoot.Mapper.StuGradeMapper;
import HelloSpringBoot.domain.StuGrade;
import HelloSpringBoot.service.StuGradeService;
import HelloSpringBoot.vo.StuGradeQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StuGradeServiceImpl extends ServiceImpl<StuGradeMapper,StuGrade> implements StuGradeService {

    @Autowired
    private StuGradeMapper stuGradeMapper;
    @Override
    public List<StuGrade> getAllGrade() {
        return stuGradeMapper.getAllGrade();
    }

    @Override
    public IPage<StuGrade> getGradeByPage(IPage<StuGrade> page, StuGradeQueryVo stuGradeQueryVo) {
        return stuGradeMapper.getGradeByPage(page, stuGradeQueryVo);
    }

    @Override
    public int insertGrades(List<StuGrade> list) {
        for (StuGrade stuGrade: list) {
            stuGrade.countSum();
            stuGrade.countAver();
            stuGrade.setId(1);
        }
        stuGradeMapper.insertGrades(list);
        return 1;
    }


}
