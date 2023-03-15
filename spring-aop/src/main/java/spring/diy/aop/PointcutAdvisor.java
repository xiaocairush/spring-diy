package spring.diy.aop;

public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
