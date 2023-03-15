package spring.diy.framework.test.common;

import spring.diy.framework.beans.factory.ConfigurableListableBeanFactory;
import spring.diy.framework.beans.factory.config.BeanDefinition;
import spring.diy.framework.beans.BeansException;
import spring.diy.framework.beans.PropertyValue;
import spring.diy.framework.beans.PropertyValues;
import spring.diy.framework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "guoka"));
    }

}
