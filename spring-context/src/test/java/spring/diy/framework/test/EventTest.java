package spring.diy.framework.test;

import org.junit.Test;
import spring.diy.framework.context.support.ClassPathXmlApplicationContext;
import spring.diy.framework.test.event.CustomEvent;

public class EventTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}
