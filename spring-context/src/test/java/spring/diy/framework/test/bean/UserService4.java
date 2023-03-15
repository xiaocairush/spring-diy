package spring.diy.framework.test.bean;

import spring.diy.framework.beans.factory.annotation.Autowired;
import spring.diy.framework.beans.factory.annotation.Value;
import spring.diy.framework.context.stereotype.Component;

import java.util.Random;

@Component("userService4")
public class UserService4 implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao4 userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001") + "，" + token;
    }

    @Override
    public String register(String userName) {
        return null;
    }

}
