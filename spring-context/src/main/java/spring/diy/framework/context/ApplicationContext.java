package spring.diy.framework.context;

import spring.diy.framework.beans.factory.ListableBeanFactory;
import spring.diy.framework.context.event.ApplicationEventPublisher;

public interface ApplicationContext extends ListableBeanFactory , ApplicationEventPublisher {
}
