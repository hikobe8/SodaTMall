package learn_servlet.cart.dao;

import learn_servlet.cart.bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new ProductDao().listProduct().size());
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8", "root",
                "root");

    }

    public List<Product> listProduct() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from product order by id desc";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getFloat(3));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

}
