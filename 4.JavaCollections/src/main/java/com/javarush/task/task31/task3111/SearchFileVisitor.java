package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean pareOfNameBool = true;
        boolean partOfContentBool = true;
        boolean maxSizeBool = true;
        boolean minSizeBool = true;
        if (partOfName != null && !(file.getFileName().toString().contains(partOfName))) pareOfNameBool = false;
        String conteinsTxt = new String(content);
        if (conteinsTxt != null) {
            if (partOfContent != null && !conteinsTxt.contains(partOfContent)) {
                if (!foundFiles.contains(file)) partOfContentBool = false;
            }
        }
        if (maxSize > 0) {
            if (!(content.length < maxSize)) {
                if (!foundFiles.contains(file)) maxSizeBool = false;
            }
        }

        if (minSize > 0) {
            if (!(content.length > minSize)) {
                if (!foundFiles.contains(file)) minSizeBool = false;
            }
        }
        if (pareOfNameBool && partOfContentBool && maxSizeBool && minSizeBool) foundFiles.add(file);
        //return visitFile(file, attrs);
        return super.visitFile(file, attrs);
    }
}
