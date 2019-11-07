package learn_servlet.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建项目所需要的数据库和相关表
 */
public class DatabaseCreator {

    public static String DB_URL = "jdbc:mysql://127.0.0.1:3306/";
    public static String DB_NAME = "how2java";
    public static String DB_USER = "root";
    public static String DB_PWD = "root";
    public static String CREATE_HERO_TABLE = "CREATE TABLE IF NOT EXISTS hero (" +
            "  id int(11) AUTO_INCREMENT," +
            "  name varchar(30) ," +
            "  hp float ," +
            "  damage int(11) ," +
            "  PRIMARY KEY (id)" +
            ")  DEFAULT CHARSET=utf8;";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER,
                        DB_PWD);
                Statement stat = connection.createStatement();
        ) {
            System.out.println("创建数据库" + DB_NAME);
            stat.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println("创建数据库" + DB_NAME + "成功!");
            stat.close();
            connection.close();
            try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER,
                    DB_PWD);
                 Statement st = conn.createStatement();) {
                System.out.println("创建数据表 hero");
                st.execute(CREATE_HERO_TABLE);
                System.out.println("创建数据表 hero 成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
