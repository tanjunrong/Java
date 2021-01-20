package com.company;

import java.sql.*;

public class MyDB {
    static Connection connection;// Connection对象
    static PreparedStatement sql;// 预处理对象
    static ResultSet resultSet;// 结果集对象
    // 连接数据库

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql:"+
                            "//127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false",
                    "root","mysql123456");

            System.out.println("1111");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        MyDB myDB = new MyDB();
        connection = myDB.getConnection();



        try {
            sql = connection.prepareStatement("select * from student where ID = 3");
            //sql.setInt(1,3);
            resultSet = sql.executeQuery();
            while (resultSet.next()){
                System.out.println("ID"+resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
