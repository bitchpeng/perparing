package com.bitchpeng.iotpl.socket.bio.B;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) throws Exception {
        Socket socket=new Socket("127.0.0.1",9090);

        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner=new Scanner(System.in);
        PrintStream printStream=new PrintStream(outputStream);
        while (true){
            System.out.println("请输入");
            scanner.nextLine();
            printStream.println("client:"+Thread.currentThread().getId());
            printStream.flush();


        }



    }


}
