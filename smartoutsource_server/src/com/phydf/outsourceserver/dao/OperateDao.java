package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Admin;
import com.phydf.outsourceserver.bean.Journal;
import com.phydf.outsourceserver.bean.Operation;

import java.util.List;

public interface OperateDao {

    int addOperate(String name,int isleagl);

    int deleteOperate(String key, String value);

    List<Operation> searchOperate(String key, String value);


}
