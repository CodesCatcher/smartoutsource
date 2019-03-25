package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Journal;
import com.phydf.outsourceserver.bean.Project;
import com.phydf.outsourceserver.dao.ProjectDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImp implements ProjectDao {
    @Override
    public int addProject(String name, int safety, int urgency, String describe, String aid) {
        return 0;
    }

    @Override
    public int deleteProject(String key, String value) {
        return 0;
    }

    @Override
    public List<Project> searchProject(String key, String value) {
        return null;
    }

    @Override
    public List<Project> serachLikeProject(String value) {

        Connection conn;
        Statement statement;
        ResultSet resultSet;
        String sql;
        List<Project> projectList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql:"
                    + "//120.24.252.244:3306/smartoutsource?characterEncoding=gbk", "phydf", "phydfphydf");
            statement = conn.createStatement();
            sql = "select * from PT,Team,Project where PT.Pid=Project.Pid and PT.Tid=Team.Tid and concat(PT.Pid,Pname," +
                    "DATE_FORMAT(PTstart,'%Y-%d-%m'),DATE_FORMAT(PTstop,'%Y-%d-%m'),PTstate,Tname,CAST(PTprogress AS CHAR)) " +
                    "like '%" + value + "%'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Project project = new Project();
                project.setTeamname(resultSet.getString("Tname"));
                project.setProgress(resultSet.getInt("PTprogress"));
                project.setStartTime(resultSet.getDate("PTstart"));
                project.setEndTime(resultSet.getDate("PTstop"));
                project.setName(resultSet.getString("Pname"));
                project.setId(resultSet.getString("Pid"));
                project.setState(resultSet.getString("PTstate"));
                projectList.add(project);
            }
            statement.close();
            resultSet.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectList;
    }

    public static void main(String[] args) {
        ProjectDaoImp pTest = new ProjectDaoImp();
        pTest.serachLikeProject("Эт5Аќ");
    }
}
