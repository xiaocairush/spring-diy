package spring.diy.framework.beans;

public class BeansException extends RuntimeException{

    public BeansException(String message, Throwable e) {
        super(message, e);
    }

    public BeansException(String message) {
        super(message);
    }

}
