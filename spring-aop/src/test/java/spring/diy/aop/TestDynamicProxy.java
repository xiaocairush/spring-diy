package spring.diy.aop;

import org.junit.Test;
import spring.diy.aop.aspectj.AspectJExpressionPointcut;
import spring.diy.aop.bean.IUserService;
import spring.diy.aop.bean.UserService;
import spring.diy.aop.bean.UserServiceInterceptor;
import spring.diy.aop.framework.Cglib2AopProxy;
import spring.diy.aop.framework.JdkDynamicAopProxy;

public class TestDynamicProxy {

    @Test
    public void test_dynamic() {
        UserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* spring.diy.aop.bean.IUserService.*(..))"));

        IUserService proxy_jdk = (IUserService)  new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }
}
