package com.bitchpeng.iotpl.stream;


import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
public class NioTest {

    public static void main(String[] args) {

//        buffer();
//        channelRead();
        test();
    }

    public static void buffer(){
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("-------put--------");
        byteBuffer.put("12312".getBytes(StandardCharsets.UTF_8));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("------flip---------");
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        char[] array = StandardCharsets.UTF_8.decode(byteBuffer).array();
        String s = String.valueOf(array);
        System.out.println(s);
        System.out.println("------clear---------");

        ByteBuffer buf=ByteBuffer.allocate(10);
        buf.put("12345".getBytes(StandardCharsets.UTF_8));
        buf.flip();
        byte [] bytes=new byte[2];
        buf.get(bytes);
        log.info(new String(bytes,StandardCharsets.UTF_8));
        System.out.println("------mark---------");
        buf.mark();
        byte [] bytes2=new byte[2];
        buf.get(bytes2);
        log.info(new String(bytes2,StandardCharsets.UTF_8));
        System.out.println("------reset---------");
        buf.reset();
        byte [] bytes3=new byte[2];
        buf.get(bytes3);
        log.info(new String(bytes3,StandardCharsets.UTF_8));
        System.out.println("------直接缓冲区---------");
        ByteBuffer bf=ByteBuffer.allocateDirect(1024);//分配直接缓冲区
        System.out.println(bf.isDirect());//是否时直接缓冲区



    }

    public static void channelWrite(){
        //双向读写数据
        //可以通过输入输出流 socket getChannel来获取通道

        try {
            FileOutputStream os=new FileOutputStream("P:\\hello3.txt");
            FileChannel channel = os.getChannel();
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            byteBuffer.put("hi,哇撒大".getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void channelRead(){
        try {
            FileInputStream fileInputStream = new FileInputStream("P:\\hello3.txt");
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            while (channel.read(allocate)>-1){
                //是的读取实在array()方法
                allocate.flip();
                //读取存储数据长度的数据
                String s = new String(allocate.array(),0,allocate.remaining());
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void channelCopy(){
        try(

                FileInputStream fileInputStream = new FileInputStream("P:\\hello3.txt");
                FileOutputStream fileOutputStream = new FileOutputStream("P:\\hello4.txt");
                FileChannel inChannel = fileInputStream.getChannel();
                FileChannel outChannel = fileOutputStream.getChannel();
        ) {


            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            int len=0;
            while (true){
                byteBuffer.clear();
                len=inChannel.read(byteBuffer);
                if(len<=-1){
                    break;
                }
                byteBuffer.flip();
                String s = new String(byteBuffer.array(), 0, len, StandardCharsets.UTF_8);
                System.out.println(s);
                outChannel.write(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //分散聚集
    public static void test(){

        try (
                FileInputStream fileInputStream = new FileInputStream("P:\\hello3.txt");
                FileOutputStream fileOutputStream = new FileOutputStream("P:\\hello4.txt");
                FileChannel inChannel = fileInputStream.getChannel();
                FileChannel outChannel = fileOutputStream.getChannel();

        ){
            ByteBuffer by1 = ByteBuffer.allocate(4);
            ByteBuffer by2 = ByteBuffer.allocate(5);
            //分散读取 将通道里面的数据读取到多个缓冲区
            //聚集写入 将多个Buffer中的数据聚集到channel
            ByteBuffer[]  byteBuffers={by1,by2};
            long len=0L;
            while (true){
                Arrays.stream(byteBuffers).forEach(Buffer::clear);
                len=inChannel.read(byteBuffers);
                if(len<=-1){
                    break;
                }
                for (ByteBuffer byteBuffer : byteBuffers) {
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(),0,byteBuffer.remaining(),StandardCharsets.UTF_8));
                    outChannel.write(byteBuffer);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //transferFrom/transferTo
    public static void transfer(){
        try (
                FileInputStream fileInputStream = new FileInputStream("P:\\hello3.txt");
                FileOutputStream fileOutputStream = new FileOutputStream("P:\\hello4.txt");
                FileChannel inChannel = fileInputStream.getChannel();
                FileChannel outChannel = fileOutputStream.getChannel();

        ){
            outChannel.transferFrom(inChannel,inChannel.position(),inChannel.size());
            //功能与上相同
            inChannel.transferTo(inChannel.position(),inChannel.size(),outChannel);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
