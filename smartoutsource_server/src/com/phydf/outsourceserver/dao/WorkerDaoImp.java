package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Admin;
import com.phydf.outsourceserver.bean.Worker;
import com.phydf.outsourceserver.dao.WorkerDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkerDaoImp implements WorkerDao {

    public String getID(){
        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String sql;
        String id="";
        Long ID;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql="SELECT Wid FROM worker order by Wid DESC";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                id=resultSet.getString("Wid");
            }
            statement.close();
            resultSet.close();
            conn.close();
            ID=Long.parseLong(id);
            ID++;
            id=String.valueOf(ID);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int addWorker(String name, String phone, String idcard,String pass) {
        Connection conn;
        Statement statement;
        String sql;
        String id=getID();
        try {
            if(searchWorker("Wphone",phone).size()!=0){
                System.out.println("联系方式已存在!");
                return 1;//用户联系方式已存在
            }else if(searchWorker("Widcard",idcard).size()!=0){
                System.out.println("该用户idcard已存在!");
                return 2;//用户联系方式已存在
            }
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql="INSERT into Worker(Wid,Wname,Wphone,Widcard,Wpass) values ('"+ id +"','"+ name + "','"+ phone +"','"+ idcard +"','"+ pass + "')";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int addWorker(String name, String phone, String idcard) {
        return 0;
    }

    @Override
    public int deleteWorker(String key, String value) {
        Connection conn;
        Statement statement;
        String sql;
        try{
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement=conn.createStatement();
            sql="DELETE FROM worker where  "+ key +" in('"+ value +"')";


            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Worker> searchWorker(String key, String value) {
        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String sql;
        List<Worker> workerList = new ArrayList<Worker>();
        try{
            conn=DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement=conn.createStatement();
            sql="SELECT* FROM worker where "+ key +" in ('"+ value +"')";
            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                Worker worker=new Worker();
                worker.setId(resultSet.getString("Wid"));
                worker.setId(resultSet.getString("Wname"));
                worker.setId(resultSet.getString("Wphone"));
                worker.setId(resultSet.getString("Widcard"));
                worker.setId(resultSet.getString("Wpass"));
                workerList.add(worker);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return workerList;
    }

    @Override
    public List<Worker> serachLikeWorker(String value) {
        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String sql;
        List<Worker> workerList=new ArrayList<>();
        try{
            conn=DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement=conn.createStatement();
            sql="SELECT* FROM worker,team where wt.wid= concat(Wid,Wname,Wphone) LIKE '%"+ value +"%'";

            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                Worker worker=new Worker();
                worker.setId(resultSet.getString("Wid"));
                worker.setName(resultSet.getString("Wname"));
                worker.setSex("男");
                worker.setPhone(resultSet.getString("Wamount"));
                worker.setPost(resultSet.getString("开心外包有限公司"));
                worker.setPass(resultSet.getString("Wpass"));
                workerList.add(worker);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return workerList;
    }
}
