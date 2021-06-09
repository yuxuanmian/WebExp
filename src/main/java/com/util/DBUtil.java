package com.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet resultSet;

    public DBUtil() {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/web";
        user = "root";
        password = "123456";
    }


    //获取connection对象
    private Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con=DriverManager.getConnection(url, user, password);
        return con;
    }

    //获取语句对象
    private PreparedStatement getPstm(String sql) throws SQLException{
        try {
            return getCon().prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pstm;
    }

    //给pstm对象赋？值
    public void setPstm(String sql,String[]params) throws SQLException{
        pstm=getPstm(sql);
        for(int i=1;i<=params.length;i++){
            pstm.setString(i,params[i-1]);
        }
    }

    //执行非查询语句
    public int update(String sql,String[]params){
        int code=0;
        try {
            setPstm(sql,params);
            code=pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return code;
    }


    //执行查询语句
    public List getResultList(String sql,String[]params){
        List list=new ArrayList();
        try {
            setPstm(sql,params);
            resultSet=pstm.executeQuery();
            ResultSetMetaData rsmd=pstm.getMetaData();
            while (resultSet.next()){
                Map map=new HashMap();
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    String col=rsmd.getColumnName(i);
                    map.put(col,resultSet.getString(col));
                }
                list.add(map);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
