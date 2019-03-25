package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class OperateDaoImp implements OperateDao {

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
            sql = "SELECT Oid FROM Operation order by Oid DESC";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getString("Oid");
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
    public int addOperate(String key,int islegal) {
        return 0;
    }

    @Override
    public int deleteOperate(String key, String value) {
        return 0;
    }

    @Override
    public List<Operation> searchOperate(String key, String value) {
        return null;
    }

}
