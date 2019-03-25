package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImp implements AdminDao {

    public String getID() {

        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String sql;
        String id = "";
        Long ID;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql = "SELECT Aid FROM Admin order by Aid DESC";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getString("Aid");
            }
            statement.close();
            resultSet.close();
            conn.close();
            ID = Long.parseLong(id);
            ID++;
            id = String.valueOf(ID);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int addAdmin(String name, String password, String phone, String email) {

        Connection conn;
        Statement statement;
        String sql;
        String id = getID();
        try {

            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql = "INSERT into Admin(Aid,Aname,Apass,Aphone,Amail) values ('" + id + "','" + name + "','" + password + "','" + phone + "','" + email + "')";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteAdminById(String id) {

        Connection conn;
        Statement statement;
        String sql;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql = "DELETE from Admin where Aid in ('" + id + "')";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Admin> searchAdmin(String key, String value) {
        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String sql;
        List<Admin> adminList = new ArrayList<Admin>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql = "select*from Admin where " + key + " in ('" + value + "') order by Aid asc";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getString("Aid"));
                admin.setName(resultSet.getString("Aname"));
                admin.setPhone(resultSet.getString("Aphone"));
                admin.setEmail(resultSet.getString("Amail"));
                admin.setPassWord(resultSet.getString("Apass"));
                adminList.add(admin);
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminList;
    }
}
