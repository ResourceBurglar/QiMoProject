package HelloSpringBoot;

import HelloSpringBoot.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 测试类注解
@SpringBootTest
public class HelloTest {

    @Autowired //自动注入 HelloController 赋值
    private HelloController helloController;  // 声明要测试的函数

    @Test // 变成单元测试函数
    public void helloControllerTest()
    {
        System.out.println(helloController.HelloSpringBoot());

    }
}
