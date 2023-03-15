package spring.diy.framework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import spring.diy.framework.beans.BeansException;
import spring.diy.framework.beans.factory.DisposableBean;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, String destroyMethodName) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = destroyMethodName;
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if(StrUtil.isEmpty(destroyMethodName) || (bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            return;
        }
        Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
        if(null == destroyMethod) {
            throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
        }
        destroyMethod.invoke(bean);
    }
}
