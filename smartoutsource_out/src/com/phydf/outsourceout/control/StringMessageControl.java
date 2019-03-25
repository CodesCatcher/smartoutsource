package com.phydf.outsourceout.control;

public class StringMessageControl implements MessageListener {
    @Override
    public void onGetMessage(String s) {

        int min, max;
        String FinalData;
        String ss;

        while (s.length() != 0) {

            min = s.indexOf("{", 0) + 1;
            max = s.indexOf("}", 0);
            FinalData = "{" + s.substring(min, max) + "}";
            if (max != s.length()) {
                s = s.substring(max + "}".length(), s.length());
            } else {
                s = "";
            }

        }


    }
}
