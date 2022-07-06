package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        List<String> list2 = new LinkedList<>();
        Queue<File> qFile = new PriorityQueue<>();

        Collections.addAll(qFile, Objects.requireNonNull(file.listFiles()));

        while (!qFile.isEmpty()) {
            File currentFile = qFile.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(qFile, Objects.requireNonNull(currentFile.listFiles()));
            } else {
                list2.add(currentFile.getAbsolutePath());
            }
        }
        return list2;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("D:/path");
        for (String a : list) {
            System.out.println(a);
        }
    }
}
/*
public class Main {
    private static ArrayList<File> listNameFile = new ArrayList<>();
    public static void getListFile(String str){
        File f = new File(str);
        for (File sam : f.listFiles()) {
            if (sam.isFile()) listNameFile.add(sam);
            else if (sam.isDirectory()) getListFile(sam.getAbsolutePath());
        }
    }
    public static void main(String[] args) throws Exception {
        getListFile("D:/path");
        for (File f : listNameFile) System.out.println(f.getAbsolutePath());
*/