package com.phydf.outsourceout.service;

import com.phydf.outsourceout.statics.Frames;
import  com.phydf.outsourceout.component.MyProjectModel;

public class SearchWorkerServiceImp implements SearchWorkerService{
    @Override
    public void search(String info) {
        int max,min;
        int flag = 0;
        String Wid,Wname,Wstart,Wend,Wstat,Wprogress;
        int WProgress;
        while(true){
            if(info.indexOf("Wid",flag)==-1) break;
            min = info.indexOf("Wid",flag);
            max = info.indexOf("Wname",flag);
            Wid = info.substring(min+5,max-2);

            min = info.indexOf("Wname",flag);
            max = info.indexOf("Wstart",flag);
            Wname = info.substring(min+7,max-2);

            min = info.indexOf("Wstart",flag);
            max = info.indexOf("Wend",flag);
            Wstart = info.substring(min+8,max-2);

            min = info.indexOf("Wend",flag);
            max = info.indexOf("Wstat",flag);
            Wend = info.substring(min+6,max-2);

            min = info.indexOf("Wstat",flag);
            max = info.indexOf("Wprogress",flag);
            Wstat = info.substring(min+8,max-2);

            min = info.indexOf("Wprogress",flag);
            max = info.indexOf(")",flag);
            Wprogress = info.substring(min+11,max-1);
            WProgress = Integer.parseInt(Wprogress);
            flag = max+1;

            //Frames.frameMain.getFrameMainProjectPage().AddProjectModel(Wid,Wname,Wstart,Wend,Wstat,WProgress);
        }
    }
}
