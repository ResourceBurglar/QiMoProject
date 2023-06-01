package HelloSpringBoot.repository;

import HelloSpringBoot.domain.StuGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StuGradeRepository extends JpaRepository<StuGrade,Integer> {
    @Query(value ="select * from stu_grade ",nativeQuery = true)
    public List<StuGrade>findStuGrade();


}
