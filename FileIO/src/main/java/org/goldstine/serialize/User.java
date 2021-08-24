package org.goldstine.serialize;

import java.io.Serializable;

public class User implements Serializable {

    //降入一个序列化版本号,表示序列化之后的文件版本为1
    private static final long serialVersionUID=1L;

    private String loginName;
    //如果对应的关键字不想被序列化，可以添加关键字transient

    private transient String password;
    private String userName;

    public User() {
    }

    public User(String loginName, String password, String userName) {
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
