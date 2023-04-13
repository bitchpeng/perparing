package com.bitchpeng.iotpl.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ByteTest {


    public void byteCopyFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
        ) {
            int date = 0;

            while ((date = fis.read()) != -1) {
                log.info(String.valueOf((char) date));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void byteCopyOutFile(String filePath,String s) {
        try (FileOutputStream  fos = new FileOutputStream(filePath);
        ) {
            fos.write(s.getBytes(StandardCharsets.UTF_8),0,s.length());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void byteCopyFile2(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
        ) {
            byte[] b=new byte[1024];
            int len=0;
            while ((len=fis.read(b)) != -1) {
                log.info(new String(b,0,len, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {



        ByteTest byteTest = new ByteTest();
        byteTest.byteCopyOutFile("P:\\hello2.txt","ha哈哈大赛的完全");

        StopWatch sw = new StopWatch();
        sw.start("task1");

        byteTest.byteCopyFile2("P:\\hello2.txt");
        sw.stop();

        log.info("任务耗时统计:[{}];", sw.getTotalTimeMillis());
    }


}
