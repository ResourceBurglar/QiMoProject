package HelloSpringBoot.controller;


import HelloSpringBoot.config.SecurityConfig;
import HelloSpringBoot.domain.StuGrade;
import HelloSpringBoot.repository.StuGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Security;
import java.util.Calendar;
import java.util.List;

@Controller
public class FilmController {
    @GetMapping("/detail/{type}/{moviefile}")
    public String toDetail(@PathVariable("type") String type, @PathVariable("moviefile")String moviefile){
        return "detail/"+type+"/"+moviefile;
    }


    @Autowired
    private StuGradeRepository stuGradeRepository;
    @GetMapping("/userLogin")
    public String customerLogin(Model model){

        List<StuGrade> stu_grade =stuGradeRepository.findStuGrade();
        model.addAttribute("stugradeList",stu_grade);
        System.out.println("-----------------------------");
        System.out.println(stu_grade);
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));//通过model对象携带数据到视图文件
        return "login";
    }
}
