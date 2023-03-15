package spring.diy.framework.test.bean;

import java.util.Objects;

public class TestFactoryBeanService {

    private String uId;
    private String company;
    private String location;
    private ITestFactoryBeanDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ITestFactoryBeanDao getUserDao() {
        return userDao;
    }

    public void setUserDao(ITestFactoryBeanDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "TestFactoryBeanService{" +
                "uId='" + uId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestFactoryBeanService that = (TestFactoryBeanService) o;
        return Objects.equals(uId, that.uId) && Objects.equals(company, that.company) && Objects.equals(location, that.location) && Objects.equals(userDao, that.userDao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, company, location);
    }
}
