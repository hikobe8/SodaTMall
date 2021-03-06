package learn_servlet.dao;

import learn_servlet.bean.HeroBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ray
 * Created At : 2019-09-05 10:43 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
public class HeroDao {

    public HeroDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                "root");

    }

    public int getCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM hero";
        try (Connection connection = getConnection(); PreparedStatement pt = connection.prepareStatement(sql);) {
            ResultSet resultSet = pt.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void add(HeroBean heroBean) {
        String sql = "insert into hero values(null, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement pt = connection.prepareStatement(sql);) {
            pt.setString(1, heroBean.name);
            pt.setFloat(2, heroBean.hp);
            pt.setInt(3, heroBean.damage);
            pt.execute();
            ResultSet resultSet = pt.getGeneratedKeys();
            if (resultSet.next()) {
                heroBean.id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete from hero where id = ?";
        try (Connection connection = getConnection(); PreparedStatement pt = connection.prepareStatement(sql);) {
            pt.setInt(1, id);
            pt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(HeroBean heroBean) {
        String sql = "update hero set name = ?, hp = ?, damage = ? where id = ?";
        try (Connection connection = getConnection(); PreparedStatement pt = connection.prepareStatement(sql);) {
            pt.setString(1, heroBean.name);
            pt.setFloat(2, heroBean.hp);
            pt.setInt(3, heroBean.damage);
            pt.setInt(4, heroBean.id);
            pt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HeroBean get(int id){
        HeroBean heroBean = null;
        String sql = "SELECT * FROM hero WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement pt = connection.prepareStatement(sql);) {
            pt.setInt(1, id);
            ResultSet resultSet = pt.executeQuery();
            if (resultSet.next()) {
                heroBean = new HeroBean();
                heroBean.id = resultSet.getInt(1);
                heroBean.name = resultSet.getString(2);
                heroBean.hp = resultSet.getFloat(3);
                heroBean.damage = resultSet.getInt(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroBean;
    }

    public List<HeroBean> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<HeroBean> list(int startIndex, int count) {
        List<HeroBean> heros = new ArrayList<HeroBean>();
        String sql = "select * from hero order by id desc limit ?,? ";
        try (Connection connection = getConnection(); PreparedStatement pt = connection.prepareStatement(sql);) {
            pt.setInt(1, startIndex);
            pt.setInt(2, count);
            ResultSet resultSet = pt.executeQuery();
            while (resultSet.next()) {
                HeroBean heroBean = new HeroBean();
                heroBean.id = resultSet.getInt(1);
                heroBean.name = resultSet.getString(2);
                heroBean.hp = resultSet.getFloat(3);
                heroBean.damage = resultSet.getInt(4);
                heros.add(heroBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

}
