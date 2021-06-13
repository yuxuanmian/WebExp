package testDBUtil;

import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;

public class testMethodNotFound {
    public static void main(String[] args) {
        LoginInfoCon lif=new LoginInfoCon();
        LoginInfoBean lib=new LoginInfoBean();
        lib.setPassword("1145141919810");
        lib.setUsername("yuxuanmian");
        if(lif.isLoginSuccess(lib, LoginInfoCon.ADMINISTRATOR))
            System.out.println("成功！");
    }
}
