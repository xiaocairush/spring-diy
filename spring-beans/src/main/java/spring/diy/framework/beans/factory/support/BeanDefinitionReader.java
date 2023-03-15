package spring.diy.framework.beans.factory.support;

import spring.diy.framework.core.io.Resource;
import spring.diy.framework.core.io.ResourceLoader;
import spring.diy.framework.beans.BeansException;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
