package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;
    public static void main(String[] args) {
        sql = "select * from table1 limit 10000";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                String Name = ret.getString(1);
//                String ufname = ret.getString(2);
//                String ulname = ret.getString(3);
//                String udate = ret.getString(4);
                System.out.println(Name);
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
