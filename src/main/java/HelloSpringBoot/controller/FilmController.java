package HelloSpringBoot.controller;


import HelloSpringBoot.Mapper.CustomerMapper;

import HelloSpringBoot.Mapper.Customer_AuthorityMapper;
import HelloSpringBoot.Mapper.StuGradeMapper;
import HelloSpringBoot.domain.Customer;

import HelloSpringBoot.domain.Customer_Authority;
import HelloSpringBoot.domain.StuGrade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private Customer_AuthorityMapper customer_authorityMapper;
    @RequestMapping("/register")
    public String register(Customer customer,Customer_Authority customer_authority){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); // 加密器
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerMapper.insertAccount(customer);

        int authority = customer_authority.getAuthority_id();
        int accountId = customer.getId();
        customer_authorityMapper.setAuthority(accountId,authority);

        System.out.println("--------------------==========="+accountId+authority);
        return "redirect:/";
    }








}
