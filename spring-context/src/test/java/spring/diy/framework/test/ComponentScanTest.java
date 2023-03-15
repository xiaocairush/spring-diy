package spring.diy.framework.test;

import org.junit.Test;
import spring.diy.framework.context.support.ClassPathXmlApplicationContext;
import spring.diy.framework.test.bean.IUserService;

public class ComponentScanTest {
    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
