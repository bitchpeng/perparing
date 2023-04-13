package com.bitchpeng.iotpl.socket.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioClientTest {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9090));
        socketChannel.configureBlocking(false);
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("请输入");
            byteBuffer.put(scanner.nextLine().getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
    }


}
