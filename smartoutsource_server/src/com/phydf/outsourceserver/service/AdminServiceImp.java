package com.phydf.outsourceserver.service;

import com.phydf.outsourceserver.bean.*;
import com.phydf.outsourceserver.dao.*;
import com.phydf.outsourceserver.factory.ServerFactory;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.List;

public class AdminServiceImp implements AdminService {

    private ServerFactory serverFactory = new ServerFactory();
    private AdminDao adminDao = serverFactory.getAdminDao();
    private ProjectDao projectDao = serverFactory.getProjectDao();
    private WorkerDao workerDao = serverFactory.getWorkerDao();
    private JournalDao journalDao = serverFactory.getJournalDao();

    @Override
    public void login(String info, Socket socket) {

        int min, max;
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    , Charset.forName("gb2312")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String account, password;
        min = info.indexOf("account") + 9;
        max = info.indexOf("password") - 2;
        account = info.substring(min, max);
        min = info.indexOf("password") + 10;
        max = info.indexOf("]}") - 1;
        password = info.substring(min, max);

        List<Admin> adminList = adminDao.searchAdmin("Aphone", account);

        if (adminList.size() != 0) {
            if (adminList.get(0).getPassword().equals(password)) {
                writer.println("{admin_login[result:\"ok\"," + "(id:\"" + adminList.get(0).getId()
                        + "\",name:\"" + adminList.get(0).getName() + "\")]}");
            } else {
                writer.println("{admin_login[result:\"err-2\"]}");
            }
            return;
        }

        adminList = adminDao.searchAdmin("Amail", account);

        if (adminList.size() != 0) {
            if (adminList.get(0).getPassword().equals(password)) {
                writer.println("{admin_login[result:\"ok\"," + "(id:\"" + adminList.get(0).getId()
                        + "\",name:\"" + adminList.get(0).getName() + "\")]}");
            } else {
                writer.println("{admin_login[result:\"err-2\"]}");
            }
        } else {
            writer.println("{admin_login[result:\"err-1\"]}");
        }

    }

    @Override
    public void searchHome(String info, Socket socket) {

        int min, max;
        PrintWriter writer = null;
        String content;
        StringBuffer recontent = new StringBuffer();

        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    , Charset.forName("gb2312")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        min = info.indexOf("content:") + 9;
        max = info.indexOf("]}") - 1;

        content = info.substring(min, max);

        List<Project> projectList = projectDao.serachLikeProject(content);

        if (projectList.size() == 0) {
            recontent.append("{admin_searchHome[result:\"0\"]}");
            writer.println(recontent.toString());
        } else {
            recontent.append("{admin_searchHome[result:\"" + projectList.size() + "\",");
            Project project;
            for (int i = 0; i < projectList.size(); i++) {
                project = projectList.get(i);
                recontent.append("(Pid:\"" + project.getId() + "\",Pname:\"" +
                        project.getName() + "\",Pstart:\"" + project.getStartTime() +
                        "\",Pend:\"" + project.getEndTime() + "\",Pteam:\"" + project.getTeamname() +
                        "\",Pstate:\"进行中\"" + ",Progress:\"" + project.getProgress() + "\")");
                if (i != projectList.size() - 1)
                    recontent.append(",");
            }
            recontent.append("]}");
            writer.println(recontent.toString());
        }
    }

    @Override
    public void searchProject(String info, Socket socket) {

        int min, max;
        PrintWriter writer = null;
        String content;
        StringBuffer recontent = new StringBuffer();

        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    , Charset.forName("gb2312")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        min = info.indexOf("content:") + 9;
        max = info.indexOf("]}") - 1;

        content = info.substring(min, max);

        List<Project> projectList = projectDao.serachLikeProject(content);

        if (projectList.size() == 0) {
            recontent.append("{admin_searchProject[result:\"0\"]}");
            writer.println(recontent.toString());
        } else {
            recontent.append("{admin_searchProject[result:\"" + projectList.size() + "\",");
            Project project;
            for (int i = 0; i < projectList.size(); i++) {
                project = projectList.get(i);
                recontent.append("(Pid:\"" + project.getId() + "\",Pname:\"" +
                        project.getName() + "\",Pstart:\"" + project.getStartTime() +
                        "\",Pend:\"" + project.getEndTime() + "\",Pteam:\"" + project.getTeamname() +
                        "\",Pstate:\"进行中\"" + ",Progress:\"" + project.getProgress() + "\")");
                if (i != projectList.size() - 1)
                    recontent.append(",");
            }
            recontent.append("]}");
            writer.println(recontent.toString());
        }
    }

    @Override
    public void searchWorker(String info, Socket socket) {

        int min, max;
        PrintWriter writer = null;
        String content;
        StringBuffer recontent = new StringBuffer();

        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    , Charset.forName("gb2312")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        min = info.indexOf("content:") + 9;
        max = info.indexOf("]}") - 1;

        content = info.substring(min, max);

        List<Worker> workerList = workerDao.serachLikeWorker(content);

        if (workerList.size() == 0) {
            recontent.append("{admin_searchWorker[result:\"0\"]}");
            writer.println(recontent.toString());
        } else {
            recontent.append("{admin_searchWorker[result:\"" + workerList.size() + "\",");
            Worker worker;
            for (int i = 0; i < workerList.size(); i++) {
                worker = workerList.get(i);
                recontent.append("(Wid:\"" + worker.getId() + "\",Wname:\"" +
                        worker.getName() + "\",Wsex:\"" + worker.getSex() +
                        "\",Wamout:\"" + worker.getAmout() + "\",Wteam:\"" + worker.getTeam() +
                        "\",Wpost:\"" + worker.getPost() + "\")");
                if (i != workerList.size() - 1)
                    recontent.append(",");
            }
            recontent.append("]}");
            writer.println(recontent.toString());
        }
    }

    @Override
    public void searchJournal(String info, Socket socket) {

        int min, max;
        PrintWriter writer = null;
        String content;
        StringBuffer recontent = new StringBuffer();

        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    , Charset.forName("gb2312")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        min = info.indexOf("content:") + 9;
        max = info.indexOf("]}") - 1;

        content = info.substring(min, max);

        List<Journal> journalList = journalDao.searchLikeJournal(content);

        if (journalList.size() == 0) {
            recontent.append("{admin_searchJournal[result:\"0\"]}");
            writer.println(recontent.toString());
        } else {
            recontent.append("{admin_searchJournal[result:\"" + journalList.size() + "\",");
            Journal journal;
            for (int i = 0; i < journalList.size(); i++) {
                journal = journalList.get(i);
                recontent.append("(Jtime:\"" + journal.getTime().toString()
                        .substring(0, journal.getTime().toString().length() - 4) + "\",Jworker:\"" +
                        journal.getWorker() + "\",Jip:\"" + journal.getIp() +
                        "\",Jdepict:\"" + journal.getDescribe() + "\")");
                if (i != journalList.size() - 1)
                    recontent.append(",");
            }
            recontent.append("]}");
            writer.println(recontent.toString());
        }
    }

}
