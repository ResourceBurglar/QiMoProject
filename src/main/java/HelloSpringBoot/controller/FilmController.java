package HelloSpringBoot.controller;



import HelloSpringBoot.Mapper.CustomerMapper;
import HelloSpringBoot.Mapper.Customer_AuthorityMapper;
import HelloSpringBoot.Mapper.StuClassMapper;
import HelloSpringBoot.Mapper.StuGradeMapper;
import HelloSpringBoot.domain.Customer;
import HelloSpringBoot.domain.Customer_Authority;
import HelloSpringBoot.domain.StuClass;
import HelloSpringBoot.domain.StuGrade;
import HelloSpringBoot.service.StuGradeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
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
        for (StuGrade stuGrade : GradeList) {
            System.out.println(stuGrade);
        }
        model.addAttribute("StuGradeList",GradeList);
        model.addAttribute("fields", getFields(StuGrade.class));
        System.out.println(GradeList);

        return "index";
    }

    @PostMapping("/insertGrade")
    public String insertGrade(@RequestBody List<StuGrade> stuGrades){
        stuGradeService.insertGrades(stuGrades);

        return "index";
    }

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private Customer_AuthorityMapper customer_authorityMapper;
    @RequestMapping("/register")
    public String register(Customer customer, Customer_Authority customer_authority){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); // 加密器
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerMapper.insertAccount(customer);

        int authority = customer_authority.getAuthority_id();
        int accountId = customer.getId();
        if (authority==3){
            String stuname = customer.getUsername();
            stuGradeMapper.addStuButNoClass(stuname);
            customer_authorityMapper.setAuthority(accountId,authority);
        }else{
        customer_authorityMapper.setAuthority(accountId,authority);}

        System.out.println("--------------------==========="+accountId+authority);
        return "redirect:/";
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


    @Autowired
    private StuGradeMapper stuGradeMapper;
    @RequestMapping("/delete/{id}")
    public String DeleteGradeById(@PathVariable Integer id){
        stuGradeMapper.deleteGradeById(id);
        System.out.println(id);
        return "redirect:/";
    }
    @Autowired
    private StuClassMapper stuClassMapper;
    @RequestMapping("/admin/distributeClass.html")
    public String addStudenClasstView(Model model){
        List<StuClass>ClassList = stuClassMapper.findallClass();
        model.addAttribute("Classlist",ClassList);

        List<StuGrade>notclassSTU = stuGradeMapper.NotClassStu();

            model.addAttribute("notClasslist",notclassSTU);


        return "admin/distributeClass";
    }

    @RequestMapping("/distributeClass")
    public String distributeClass(@RequestParam String classname,@RequestParam String id){

        List<String> classn = new ArrayList<>();
        System.out.println(classname);
        String[] splitclassname = classname.split(",");
        for (String finalClassname:splitclassname){
            System.out.println(finalClassname);
            classn.add(finalClassname);
        }

        List<String> classnid = new ArrayList<>();
        System.out.println(id);
        String[] splitid = id.split(",");
        for (String finalid : splitid){
            System.out.println(finalid);
            classnid.add(finalid);
        }

        for (int i = 0;i < classn.size();i ++)
        {
            stuGradeMapper.distributeClass(classn.get(i),Integer.parseInt(classnid.get(i)));
        }

        return "redirect:/admin/distributeClass.html";
    }



}
