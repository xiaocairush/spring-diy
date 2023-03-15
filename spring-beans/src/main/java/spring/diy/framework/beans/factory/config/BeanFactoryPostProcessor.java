package spring.diy.framework.beans.factory.config;

import spring.diy.framework.beans.factory.ConfigurableListableBeanFactory;
import spring.diy.framework.beans.BeansException;

import java.io.IOException;

public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
