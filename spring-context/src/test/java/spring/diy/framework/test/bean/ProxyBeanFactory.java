package spring.diy.framework.test.bean;

import spring.diy.framework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyBeanFactory implements FactoryBean<ITestFactoryBeanDao> {

    @Override
    public ITestFactoryBeanDao getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "小傅哥");
            hashMap.put("10002", "八杯水");
            hashMap.put("10003", "阿毛");

            return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
        };

        return (ITestFactoryBeanDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{ITestFactoryBeanDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return ITestFactoryBeanDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
