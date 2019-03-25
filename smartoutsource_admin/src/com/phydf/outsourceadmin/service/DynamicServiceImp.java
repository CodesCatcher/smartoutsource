package com.phydf.outsourceadmin.service;

import com.phydf.outsourceadmin.statics.Frames;

public class DynamicServiceImp implements DynamicService{
    @Override
    public void addDynamic(String info) {
        int min,max;
        String Time,Name,Event;

        min = info.indexOf("Time");
        max = info.indexOf("Wname");
        Time = info.substring(min+6,max-2);

        min = info.indexOf("Wname");
        max = info.indexOf("Event");
        Name = info.substring(min+7,max-2);

        min = info.indexOf("Event");
        max = info.indexOf("]");
        Event = info.substring(min+7,max-1);
        System.out.println(Time+Name+Event);
        Frames.frameMain.getFrameMainHomePage().addDynamicData(Time,Name,Event);
    }
}
