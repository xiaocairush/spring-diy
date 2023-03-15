package spring.diy.framework.test.common;

import spring.diy.framework.beans.factory.config.BeanPostProcessor;
import spring.diy.framework.test.bean.UserService;
import spring.diy.framework.beans.BeansException;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
