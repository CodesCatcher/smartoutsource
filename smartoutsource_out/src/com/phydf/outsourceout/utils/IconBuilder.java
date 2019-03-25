package com.phydf.outsourceout.utils;

import com.phydf.outsourceout.frames.FrameMain;

import java.net.URL;

public class IconBuilder {

    public static URL getUrl(String imageName) {
        URL IconUrl = FrameMain.class.getResource("/drawable");
        try {
            return new URL(IconUrl.toString() + "/" + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
