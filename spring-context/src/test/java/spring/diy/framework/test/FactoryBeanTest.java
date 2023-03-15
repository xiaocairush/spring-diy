package spring.diy.framework.test;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import spring.diy.framework.context.support.ClassPathXmlApplicationContext;
import spring.diy.framework.test.bean.TestFactoryBeanService;

public class FactoryBeanTest {

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-factory-bean.xml");
        applicationContext.registerShutdownHook();

        TestFactoryBeanService userService01 = applicationContext.getBean("userService", TestFactoryBeanService.class);
        TestFactoryBeanService userService02 = applicationContext.getBean("userService", TestFactoryBeanService.class);

        System.out.printf(userService01.toString());
        System.out.printf(userService02.toString());

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-factory-bean.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        TestFactoryBeanService userService = applicationContext.getBean("userService", TestFactoryBeanService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
