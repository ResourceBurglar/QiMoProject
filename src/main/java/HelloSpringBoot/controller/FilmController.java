package HelloSpringBoot.controller;



import HelloSpringBoot.domain.StuGrade;
import HelloSpringBoot.service.StuGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.security.Security;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
    StuGradeService stuGradeService;
    @GetMapping("/")
    public String indexView(Model model) {
        List<StuGrade> GradeList = stuGradeService.getAllGrade();
        model.addAttribute("StuGradeList",GradeList);
        model.addAttribute("fields", getFields(StuGrade.class));
        System.out.println(GradeList);
        return "index";
    }

    @PostMapping("/insertGrade")
    @CrossOrigin(origins="*")
    public String insertGrade(@RequestBody List<StuGrade> stuGrades){
        stuGradeService.insertGrades(stuGrades);

        return "index";
    }


    // 动态获取属性名
    public List getFields(Class<?> className) {
        Field[] fields = className.getDeclaredFields();
        List list = new ArrayList();
        for (Field field : fields) {
            String name = field.getName();
            if (!(name.equals("id")  || name.equals("classid"))) {
                list.add(name);
            }
        }
        return list;
    }



}
