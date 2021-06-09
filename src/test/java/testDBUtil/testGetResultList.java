package testDBUtil;

import com.util.DBUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class testGetResultList {
    public static void main(String[] args) {
        DBUtil dbUtil=new DBUtil();
        String sql="select * from book";
        List a=dbUtil.getResultList(sql,new String[]{});
        Iterator it=a.iterator();
        while (it.hasNext()){
            Map map=(Map) it.next();
            for (Object o : map.keySet()) {
                System.out.printf(((String)map.get(o)));
            }
        }
    }
}
