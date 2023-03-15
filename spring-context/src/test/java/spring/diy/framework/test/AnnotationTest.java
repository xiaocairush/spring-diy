package spring.diy.framework.test;

import org.junit.Test;
import spring.diy.framework.context.support.ClassPathXmlApplicationContext;
import spring.diy.framework.test.bean.IUserService;

public class AnnotationTest {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-annotation.xml");
        IUserService userService = applicationContext.getBean("userService4", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
