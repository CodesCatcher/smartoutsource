package com.phydf.outsourceserver.factory;

import com.phydf.outsourceserver.control.MessageListener;
import com.phydf.outsourceserver.control.StringMessageControl;
import com.phydf.outsourceserver.dao.*;
import com.phydf.outsourceserver.service.AdminService;
import com.phydf.outsourceserver.service.AdminServiceImp;

public class ServerFactory {

    public AdminDao getAdminDao(){
        return new AdminDaoImp();
    }

    public OperateDao getOperateDao(){
        return new OperateDaoImp();
    }

    public ProjectDao getProjectDao(){
        return new ProjectDaoImp();
    }

    public WorkerDao getWorkerDao(){
        return new WorkerDaoImp();
    }

    public AdminService getAdminService(){
        return new AdminServiceImp();
    }

    public MessageListener getStringMessageControl(){ return new StringMessageControl(); }

    public JournalDao getJournalDao(){
        return new JournalDaoImp();
    }

}
