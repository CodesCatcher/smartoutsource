package com.phydf.outsourceserver.dao;


import com.phydf.outsourceserver.bean.Project;

import java.util.List;

public interface ProjectDao {

    int addProject(String name, int safety, int urgency, String describe, String aid);

    int deleteProject(String key, String value);

    List<Project> searchProject(String key, String value);

    List<Project> serachLikeProject(String value);

}
