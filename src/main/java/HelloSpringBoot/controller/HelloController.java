package HelloSpringBoot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//控制器类,用这个注解，使得该类变成控制器类，发送请求
@RestController // restcontroller返回数据  @RestController== @controller+@responsebody(返回数据)
public class HelloController {




    @GetMapping("/hello") //把浏览器的请求映射到这个HelloSpringBoot 函数
    public String HelloSpringBoot(){ // 请求处理函数

        return "HelloSpringBootTEST";
    }



}
