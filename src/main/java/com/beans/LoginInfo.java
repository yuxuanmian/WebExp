package com.beans;



//用户登录类，包含用户名和密码，生成了构造函数、getter、setter
public class LoginInfo {
    private String username;
    private String password;

    public LoginInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
