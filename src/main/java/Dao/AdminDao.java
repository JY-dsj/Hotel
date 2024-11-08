package Dao;

import Util.UserUtil;
import bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author 2022
 */
public class AdminDao {
    public boolean insert(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = UserUtil.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "INSERT INTO users(id,account,password) "+
                    "VALUES("
                    + user.getAccount()
                    + "','"
                    + user.getPassword()
                    + "','";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserUtil.release(rs, stmt, conn);
        }
        return false;
    }
    //查询所有User对象
    public ArrayList<User> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList <User>list = new ArrayList<User>() ;
        try{
            //获得数据的连接
            conn = UserUtil .getConnection() ;
            //获取Statement对象
            stmt = conn.createStatement() ;
            //发送SQL语句
            String sql = "select * from users";
            rs = stmt.executeQuery(sql) ;
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setAccount(rs.getString("Account"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserUtil.release(rs, stmt, conn);
        }
        return null;
    }
    // 根据id查找指定的user
    public User find(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = UserUtil .getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM users WHERE id=" + id;
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setAccount(rs.getString("account") ); ;
                user.setPassword(rs.getString("password"));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserUtil.release(rs, stmt, conn);
        }
        return null;
    }
    // 删除用户
    public boolean delete(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = UserUtil.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "DELETE FROM users WHERE id=" + id;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserUtil.release(rs, stmt, conn);
        }
        return false;
    }
    // 修改用户
    public boolean update(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = UserUtil.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "UPDATE users set name='" + user.getAccount()
                    + "',password='" + user.getPassword();
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserUtil.release(rs, stmt, conn);
        }
        return false;
    }
}
