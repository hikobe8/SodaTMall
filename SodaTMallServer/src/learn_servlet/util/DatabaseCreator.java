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

    private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/";
    public static String DB_NAME_HOW2JAVA = "how2java";
    private static String DB_USER = "root";
    private static String DB_PWD = "root";
    private static String CREATE_HERO_TABLE = "CREATE TABLE IF NOT EXISTS hero (" +
            "  id int(11) AUTO_INCREMENT," +
            "  name varchar(30) ," +
            "  hp float ," +
            "  damage int(11) ," +
            "  PRIMARY KEY (id)" +
            ")  DEFAULT CHARSET=utf8;";

    private static String DB_NAME_CART = "cart";

    private static String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS `product` (" +
            "  `id` int(11) DEFAULT NULL," +
            "  `name` varchar(50) DEFAULT NULL," +
            "  `price` float DEFAULT NULL" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        createHeroDataBase();
        createCartDataBase();
    }

    private static void createCartDataBase() {
        createDataBase(DB_NAME_CART);
        createTable(DB_NAME_CART, CREATE_PRODUCT_TABLE);
    }

    private static void createHeroDataBase() {
        createDataBase(DB_NAME_HOW2JAVA);
        createTable(DB_NAME_HOW2JAVA, CREATE_HERO_TABLE);
    }

    private static void createDataBase(String dbName) {
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER,
                        DB_PWD);
                Statement stat = connection.createStatement();
        ) {
            System.out.println("创建数据库" + dbName);
            stat.execute("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("创建数据库" + dbName + "成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(String dbName, String tableSql) {
        try (
                Connection connection = DriverManager.getConnection(DB_URL + dbName, DB_USER,
                        DB_PWD);
                Statement stat = connection.createStatement();
        ) {
            Statement st = connection.createStatement();
            System.out.println("创建数据表..");
            st.execute(tableSql);
            System.out.println("创建数据表成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
