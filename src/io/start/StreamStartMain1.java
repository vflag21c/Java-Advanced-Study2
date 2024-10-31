package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
//        FileOutputStream fos = new FileOutputStream("temp/hello.dat", true); //이어서 작성
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false); //새로 생성
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");

        int data;
        while ((data = fis.read()) != -1) {
            System.out.println(data);
        }
        fis.close();
    }
}
