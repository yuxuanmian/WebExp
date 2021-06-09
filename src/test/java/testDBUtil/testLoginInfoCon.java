package testDBUtil;

import com.beans.BookBean;
import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;

import java.util.List;

public class testLoginInfoCon {
    public static void main(String[] args) {
        LoginInfoCon loginInfoCon=new LoginInfoCon();
        List<LoginInfoBean> li=loginInfoCon.getAllUser("select * from user",new String[]{});
        for(LoginInfoBean temp:li){
            System.out.println(li);
        }
    }
}
