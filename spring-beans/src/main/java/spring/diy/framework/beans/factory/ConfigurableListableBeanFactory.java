package spring.diy.framework.beans.factory;

import spring.diy.framework.beans.factory.config.BeanDefinition;
import spring.diy.framework.beans.factory.config.ConfigurableBeanFactory;
import spring.diy.framework.beans.BeansException;
import spring.diy.framework.beans.factory.config.AutowireCapableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
