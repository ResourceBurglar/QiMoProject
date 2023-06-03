package HelloSpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//变成启动类

@MapperScan("HelloSpringboot.Mapper")
@SpringBootApplication // 注解,使得该类变成启动类
public class HelloSpringBoot {
    public static void main(String[] args){ // static 静态属于class
        SpringApplication.run(HelloSpringBoot.class);

    }

}
