package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Admin;

import java.util.List;

public interface AdminDao {

    int addAdmin(String name, String password, String phone, String email);

    int deleteAdminById(String id);

    List<Admin> searchAdmin(String key, String value);

}
