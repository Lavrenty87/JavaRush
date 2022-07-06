package com.javarush.task.task31.task3101;

/*
Проход по дереву файлов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File change = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(change)) {
            FileUtils.deleteFile(change);
        }
        FileUtils.renameFile(resultFileAbsolutePath, change);

        try {
            FileOutputStream writer = new FileOutputStream(change);
            Queue<File> qPath = new PriorityQueue<>();
            TreeMap<String, File> nameFile = new TreeMap<>();
            Collections.addAll(qPath, Objects.requireNonNull(path.listFiles()));
            while (!qPath.isEmpty()) {
                File currentFileQueue = qPath.remove();
                if (currentFileQueue.isDirectory())
                    Collections.addAll(qPath, Objects.requireNonNull(currentFileQueue.listFiles()));
                else if (currentFileQueue.length() <= 50) nameFile.put(currentFileQueue.getName(),
                        currentFileQueue.getAbsoluteFile());
            }

            for (Map.Entry<String, File> map : nameFile.entrySet()) {
                String key = map.getKey();
                File value = map.getValue();
                FileReader readerFile = new FileReader(value);
                while (readerFile.ready()) writer.write(readerFile.read());
                readerFile.close();
                writer.write("\n".getBytes());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
