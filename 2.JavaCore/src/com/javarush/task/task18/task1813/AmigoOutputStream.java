package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public static String fileName = "C:/tmp/result.txt";

    public FileOutputStream original;

    public AmigoOutputStream(FileOutputStream original) throws FileNotFoundException {
        super(fileName);
        this.original = original;
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void close() throws IOException {
        original.flush();
        String date = "JavaRush © All rights reserved.";
        original.write(date.getBytes());
        original.close();
    }

    @Override
    public void write(byte[] b) throws IOException {
       original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }
}
