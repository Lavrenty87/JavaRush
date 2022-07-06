package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static java.nio.file.Files.isDirectory;

/* 
Что внутри папки?
*/

public class Solution {
    private static AtomicInteger dirCount = new AtomicInteger(0);
    private static AtomicInteger fileCount = new AtomicInteger(0);
    private  static AtomicLong allSize = new AtomicLong(0);

    public static void main(String[] args) throws IOException {
        BufferedReader readerPath = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(readerPath.readLine());
        if (isDirectory(path)) {
            Files.walkFileTree(path, new HashSet<>(), Integer.MAX_VALUE, new MyFileVisitor());
        }else System.out.println(path.toString() + " - не папка");
        System.out.println(String.format("Всего папок - %d\n" +
                "Всего файлов - %d\n" +
                "Общий размер - %d\n", dirCount.get() - 1, fileCount.get(), allSize.get()));
    }
    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!Files.isDirectory(file)){
                fileCount.getAndIncrement();
                long a = Files.size(file) + allSize.get();
                allSize.getAndSet(a);
            }
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            dirCount.getAndIncrement();
            return super.postVisitDirectory(dir, exc);
        }
    }
}
