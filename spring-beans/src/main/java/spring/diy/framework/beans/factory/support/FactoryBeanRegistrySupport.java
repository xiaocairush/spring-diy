package spring.diy.framework.beans.factory.support;

import spring.diy.framework.beans.BeansException;
import spring.diy.framework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object o = this.factoryBeanObjectCache.get(beanName);
        return o != NULL_OBJECT ? o : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if(factory.isSingleton()) {
            Object o = this.factoryBeanObjectCache.get(beanName);
            if(o == null) {
                o = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (o != null? o : NULL_OBJECT));
            }
            return o != NULL_OBJECT ? o : null;
        }
        return doGetObjectFromFactoryBean(factory, beanName);
    }

    private Object doGetObjectFromFactoryBean(FactoryBean factory, String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}
