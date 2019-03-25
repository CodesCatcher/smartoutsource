package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Journal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JournalDaoImp implements JournalDao {
    @Override
    public List<Journal> searchLikeJournal(String value) {
        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String sql;
        List<Journal> journalList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql = "select*from WO,Worker,Operation where WO.Wid=Worker.Wid and WO.Oid=Operation.Oid and " +
                    "contact(DATE_FORMAT(WOtime,'%Y-%d-%m'),WOip,Oname,Wname) like '%"+value+"%'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Journal journal = new Journal();
                journal.setTime(resultSet.getTimestamp("WOtime"));
                journal.setDescribe(resultSet.getString("Oname"));
                journal.setIp(resultSet.getString("WOip"));
                journal.setWorker(resultSet.getString("Wname"));
                journalList.add(journal);
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return journalList;
    }
}
