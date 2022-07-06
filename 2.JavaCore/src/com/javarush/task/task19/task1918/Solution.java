package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Solution {
    public static void main(String[] args) {
        String str = null;
        List<String> list = new ArrayList<>();
        BufferedReader reader =  null;
        BufferedReader readerFile = null;
        try {
            reader =  new BufferedReader( new InputStreamReader(System.in));
            readerFile = new BufferedReader(new FileReader(reader.readLine()));
            while (readerFile.ready()) {
                if (str == null) str = readerFile.readLine();
                else str += readerFile.readLine();
            }
            Document document = Jsoup.parse(str, "", Parser.xmlParser());
            Elements elements = document.select(args[0]);
            for(int i = 0; i < elements.size();i++) {
                System.out.println(elements.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(reader).close();
                Objects.requireNonNull(readerFile).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
