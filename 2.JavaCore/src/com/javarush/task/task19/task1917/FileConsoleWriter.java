package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/
// Пример композиции
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }


    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i < len + off; i++) System.out.print(cbuf[i]);
    }


    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        char[] cbuf = str.toCharArray();
        for (int i = off; i < len + off; i++) System.out.print(cbuf[i]);
    }


    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        for (char a : cbuf) System.out.print(a);
    }


    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);

    }


    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
       /* FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("D:/4.txt");
        fileConsoleWriter.write("1234567890",2,8);
        char[] arr = {'9','8','7','6','5','4','3','2','1','0'};
        System.out.println();
        fileConsoleWriter.write(arr, 7,3);
        fileConsoleWriter.close();

        FileWriter fileWriter1 = new FileWriter("D:/2.txt");
        fileWriter1.write("1234567890",2,8);
        fileWriter1.write(arr, 7,3);
        fileWriter1.close();*/
    }
}
