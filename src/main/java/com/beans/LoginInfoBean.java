package com.beans;



//用户登录类，包含用户名和密码，生成了构造函数、getter、setter
public class LoginInfoBean {
    private String username;
    private String password;

    public LoginInfoBean() {
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

    @Override
    public String toString() {
        return "LoginInfoBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        LoginInfoBean temp=(LoginInfoBean) obj;
        if(this.getPassword().equals(temp.getPassword())&&this.getUsername().equals(temp.getUsername())){
            return true;
        }else  {
            return false;
        }
    }
}
