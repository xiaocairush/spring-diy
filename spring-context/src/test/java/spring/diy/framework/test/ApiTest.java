package spring.diy.framework.test;

import spring.diy.framework.test.bean.UserService;
import org.junit.Assert;
import org.junit.Test;
import spring.diy.framework.beans.factory.config.BeanDefinition;
import spring.diy.framework.beans.factory.config.BeanReference;
import spring.diy.framework.beans.factory.support.DefaultListableBeanFactory;
import spring.diy.framework.test.bean.UserDao;
import spring.diy.framework.beans.PropertyValue;
import spring.diy.framework.beans.PropertyValues;

public class ApiTest {

//    @Test
//    public void test_BeanFactory() {
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//
//        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
//        userService_singleton.queryUserInfo();
//        Assert.assertSame(userService_singleton, userService);
//    }

//    @Test
    public void test_BeanConstructorArgs() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "mcai");
        userService.queryUserInfo();

        UserService userService_singleton = (UserService) beanFactory.getBean("userService", "mcai");
        userService.queryUserInfo();

        Assert.assertSame(userService, userService_singleton);
    }

    @Test
    public void test_SetBeanProperty() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "mcai"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
//
//        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//
//        Assert.assertSame(userService, userService_singleton);

    }

}
