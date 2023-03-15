package spring.diy.framework.beans.factory;

import spring.diy.framework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name, Object... args);

    <T> T getBean(String name, Class<T> requiredType);

    <T> T getBean(Class<T> requiredType) throws BeansException;
}
