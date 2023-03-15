package spring.diy.framework.beans.factory;

public interface DisposableBean {
    void destroy() throws Exception;
}
