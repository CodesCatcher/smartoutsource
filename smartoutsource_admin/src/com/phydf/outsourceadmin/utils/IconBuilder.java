package com.phydf.outsourceadmin.utils;

import com.phydf.outsourceadmin.frames.FrameLogin;
import java.net.URL;

public class IconBuilder {

    public static URL getUrl(String imageName) {
        URL IconUrl = FrameLogin.class.getResource("/drawable");
        try {
            return new URL(IconUrl.toString() + "/" + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
