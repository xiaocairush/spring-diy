package spring.diy.framework.test;

import org.junit.Test;
import spring.diy.framework.beans.factory.support.DefaultListableBeanFactory;
import spring.diy.framework.context.xml.XmlBeanDefinitionReader;
import spring.diy.framework.test.bean.UserService;

public class XmlTest {

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

}
