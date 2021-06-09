package testDBUtil;

import com.util.DBUtil;

public class tstdbupdate {
    public static void main(String[] args) {
        DBUtil d=new DBUtil();
        String sql="insert into book (number, bname, bauthor, bpublisher, bprice) values (?,?,?,?,?)";
        d.update(sql,new String[]{"sss","sss","sss","sss","12.5"});
    }
}
