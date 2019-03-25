package com.phydf.outsourceserver.control;

import java.net.Socket;

public interface MessageListener {

    void onGetMessage(String s, Socket socket);
}
