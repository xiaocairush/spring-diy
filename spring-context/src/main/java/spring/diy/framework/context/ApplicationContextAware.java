package spring.diy.framework.context;

import spring.diy.framework.beans.BeansException;
import spring.diy.framework.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
