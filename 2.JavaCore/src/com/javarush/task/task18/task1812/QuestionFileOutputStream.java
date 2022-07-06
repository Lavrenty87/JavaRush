package com.javarush.task.task18.task1812;

/* 
Расширяем AmigoOutputStream
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {

    public AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream original) throws IOException {

        this.original = original;
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
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
    public void close() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (bufferedReader.readLine().equals("Д")) {
            original.close();
        }
    }

    public static void main(String[] args) throws IOException {
        AmigoOutputStream amigoOutputStream = new AmigoOutputStream() {
            @Override
            public void flush() throws IOException {

            }

            @Override
            public void write(int b) throws IOException {

            }

            @Override
            public void write(byte[] b) throws IOException {

            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {

            }

            @Override
            public void close() throws IOException {

            }
        };
        QuestionFileOutputStream questionFileOutputStream = new QuestionFileOutputStream(amigoOutputStream);
        questionFileOutputStream.close();
    }
}

