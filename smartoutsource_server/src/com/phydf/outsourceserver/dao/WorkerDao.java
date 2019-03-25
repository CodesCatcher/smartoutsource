package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Worker;
import java.util.List;

public interface WorkerDao {

    int addWorker(String name, String phone, String idcard);

    int deleteWorker(String key, String value);

    List<Worker> searchWorker(String key, String value);

    List<Worker> serachLikeWorker(String value);

}
