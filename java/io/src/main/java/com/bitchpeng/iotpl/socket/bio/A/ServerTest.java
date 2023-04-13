package com.bitchpeng.iotpl.socket.bio.A;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        //会阻塞
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String msg;
        while ((msg = bufferedReader.readLine()) != null) {
            System.out.println(msg);
        }


    }


}
