package HelloSpringBoot.controller;


import HelloSpringBoot.Mapper.StuGradeMapper;
import HelloSpringBoot.config.SecurityConfig;
import HelloSpringBoot.domain.StuClass;
import HelloSpringBoot.domain.StuGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Security;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class FilmController {
    @GetMapping("/detail/{type}/{moviefile}")
    public String toDetail(@PathVariable("type") String type, @PathVariable("moviefile")String moviefile){
        return "detail/"+type+"/"+moviefile;
    }



    @GetMapping("/userLogin")
    public String customerLogin(Model model){


        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));//通过model对象携带数据到视图文件
        return "login";
    }


    @Autowired
    private StuGradeMapper stuGradeMapper;
    @GetMapping("/")
    public String indexView(Model model){
        List<StuGrade> GradeList = stuGradeMapper.getAllGrade();
        model.addAttribute("StuGradeList",GradeList);
        System.out.println(GradeList);
        return "index";
    }

    @GetMapping("/insertGrade")
    public String insertGrade(){


        return "index";
    }








}
