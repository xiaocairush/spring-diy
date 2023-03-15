package spring.diy.framework.context.event;

import spring.diy.framework.context.ApplicationEvent;

public interface ApplicationEventPublisher{

    void publishEvent(ApplicationEvent event);

}
