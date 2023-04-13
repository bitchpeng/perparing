package com.bitchpeng.iotpl.socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

@Slf4j
public class NioServerTest {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9090));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //注册selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //获取selector中的连接
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    //accept连接 获取的是服务端的 channel 追加读监控
                    SocketChannel channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    //注册读连接
                    channel.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //读连接 获取的是客户端的channel 读取客户端的数据
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    //读取
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=channel.read(byteBuffer))>0){
                        byteBuffer.flip();
                        log.info(new String(byteBuffer.array(),0,len));
                        byteBuffer.clear();
                    }
                }else if(selectionKey.isWritable()){
                    log.info("isWritable");

                }else if (selectionKey.isConnectable()){
                    log.info("isConnectable");

                }
                iterator.remove();
            }


        }


    }


}
