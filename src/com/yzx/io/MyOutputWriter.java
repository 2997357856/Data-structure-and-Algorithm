package com.yzx.io;

import org.omg.CORBA.Current;

import java.io.*;

/**
 * @Author YZX
 * @Create 2023-03-14 20:39
 * @Java-version jdk1.8
 */
//用来写入1-10000的数据到文本文件
public class MyOutputWriter {
    public static void main(String[] args) throws IOException {
        //创建文件的字节流
        FileOutputStream fos = null;
        //创建字符流
        OutputStreamWriter writer = null;
        //创建缓冲流
        BufferedWriter bf = null;
        try {
            fos = new FileOutputStream(new File("src/com/yzx/io/Num.txt"));
            writer = new OutputStreamWriter(fos);
            bf = new BufferedWriter(writer);
            long startTime = System.currentTimeMillis();
            for (int i = 100000;i>=1;i--){
                bf.write(i+"\n");
            }
            long endTime = System.currentTimeMillis();
            bf.flush();
            System.out.println("数据写入完毕,共花费"+((endTime-startTime))+"毫秒");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (fos != null) {
                fos.close();
            }
            if (writer != null) {
                writer.close();
            }
            if (bf != null) {
                bf.close();
            }
        }
    }
}
