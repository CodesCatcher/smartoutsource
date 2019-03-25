package com.phydf.outsourceadmin.service;

import com.phydf.outsourceadmin.statics.Frames;

public class SearchServiceImp implements SearchService {

    public void searchHome(String info) {

        String pid, pname, pstart, pend, pteam, pstate, progress;
        int min;
        int max;
        int Pprogress;

        int i = 0, flag = 0;


        while (true) {
            if (info.indexOf("Pid", flag) == -1) break;
            min = info.indexOf("Pid", flag);
            max = info.indexOf("Pname", flag);
            pid = info.substring(min + 5, max - 2);

            min = info.indexOf("Pname", flag);
            max = info.indexOf("Pstart", flag);
            pname = info.substring(min + 7, max - 2);

            min = info.indexOf("Pstart", flag);
            max = info.indexOf("Pend", flag);
            pstart = info.substring(min + 8, max - 2);

            min = info.indexOf("Pend", flag);
            max = info.indexOf("Pteam", flag);
            pend = info.substring(min + 6, max - 2);

            min = info.indexOf("Pteam", flag);
            max = info.indexOf("Pstate", flag);
            pteam = info.substring(min + 7, max - 2);

            min = info.indexOf("Pstate", flag);
            max = info.indexOf("Progress", flag);
            pstate = info.substring(min + 8, max - 2);

            min = info.indexOf("Progress", flag);
            max = info.indexOf(")", flag);
            progress = info.substring(min + 10, max - 1);
            Pprogress = Integer.parseInt(progress);
            flag = max + 1;


            Frames.frameMain.getFrameMainHomePage().addProjectData(pid, pname, pstart, pend, pteam, pstate, Pprogress);

        }
    }


    public void searchProject(String info) {
        String pid, pname, pstart, pend, pteam, pstate, progress;
        int min;
        int max;
        int Pprogress;

        int i = 0, flag = 0;

        while (true) {
            if (info.indexOf("Pid", flag) == -1) break;
            min = info.indexOf("Pid", flag);
            max = info.indexOf("Pname", flag);
            pid = info.substring(min + 5, max - 2);

            min = info.indexOf("Pname", flag);
            max = info.indexOf("Pstart", flag);
            pname = info.substring(min + 7, max - 2);

            min = info.indexOf("Pstart", flag);
            max = info.indexOf("Pend", flag);
            pstart = info.substring(min + 8, max - 2);

            min = info.indexOf("Pend", flag);
            max = info.indexOf("Pteam", flag);
            pend = info.substring(min + 6, max - 2);

            min = info.indexOf("Pteam", flag);
            max = info.indexOf("Pstate", flag);
            pteam = info.substring(min + 7, max - 2);

            min = info.indexOf("Pstate", flag);
            max = info.indexOf("Progress", flag);
            pstate = info.substring(min + 8, max - 2);

            min = info.indexOf("Progress", flag);
            max = info.indexOf(")", flag);
            progress = info.substring(min + 10, max - 1);
            Pprogress = Integer.parseInt(progress);
            flag = max + 1;


            Frames.frameMain.getFrameMainProjectPage().addProjectData(pid, pname, pstart, pend, pteam
                    , pstate, Pprogress);
        }
    }


    public void searchWorker(String info) {
        String Wid, Wname, Wsex, Wamount, Wteam, Wpost;
        int flag = 0, i = 0;
        int min, max;


        while (true) {
            if (info.indexOf("Wid", flag) == -1) break;
            min = info.indexOf("Wid", flag);
            max = info.indexOf("Wname", flag);
            Wid = info.substring(min + 5, max - 2);

            min = info.indexOf("Wname", flag);
            max = info.indexOf("Wsex", flag);
            Wname = info.substring(min + 7, max - 2);

            min = info.indexOf("Wsex", flag);
            max = info.indexOf("Wamount", flag);
            Wsex = info.substring(min + 6, max - 2);

            min = info.indexOf("Wamount", flag);
            max = info.indexOf("Wteam", flag);
            Wamount = info.substring(min + 9, max - 2);

            min = info.indexOf("Wteam", flag);
            max = info.indexOf("Wpost", flag);
            Wteam = info.substring(min + 7, max - 2);

            min = info.indexOf("Wpost", flag);
            max = info.indexOf(")", flag);
            Wpost = info.substring(min + 7, max - 1);

            flag = max + 1;

            Frames.frameMain.getFrameMainStaffPage().addStaff(
                    Wid, Wname, Wsex, Wamount, Wteam, Wpost);
        }
    }


    public void searchJournal(String info) {
        String Jtime, Jworker, Jip, Jdepict;
        int flag = 0, i = 0;
        int min, max;

        while (true) {

            if (info.indexOf("Jtime", flag) == -1) break;
            min = info.indexOf("Jtime", flag);
            max = info.indexOf("Jworker", flag);
            Jtime = info.substring(min + 7, max - 2);

            min = info.indexOf("Jworker", flag);
            max = info.indexOf("Jip", flag);
            Jworker = info.substring(min + 9, max - 2);

            min = info.indexOf("Jip", flag);
            max = info.indexOf("Jdepict", flag);
            Jip = info.substring(min + 5, max - 2);

            min = info.indexOf("Jdepict", flag);
            max = info.indexOf(")", flag);
            Jdepict = info.substring(min + 9, max - 1);

            flag = max + 1;

            Frames.frameMain.getFrameMainJournalPage().addJournal(Jtime, Jworker, Jip, Jdepict);
        }
    }
}
