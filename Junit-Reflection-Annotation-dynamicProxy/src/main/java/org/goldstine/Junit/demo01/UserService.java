package org.goldstine.Junit.demo01;

/**
 * 完成用户数据的增删改查操作
 *
 * 测试类：测试类的命名规范：以Test开头，以业务类名结尾，使用驼峰命名
 *      UserService===>TestUserService/UserServiceTest
 *      测试方法的命名：
 *          以test开头，以业务方法名结尾
 */
public class UserService {
    public String login(String loginName,String password){
        if("admin".equals(loginName)&&"123456".equals(password)){
            return "success";
        }else{
            return "failure";
        }
    }
}
