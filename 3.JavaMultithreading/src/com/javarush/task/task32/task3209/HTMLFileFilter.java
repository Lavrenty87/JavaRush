package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String[] fSplit = "\\.".split(f.getName());
        return f.isDirectory() || fSplit[fSplit.length - 1].equalsIgnoreCase("html")
                || fSplit[fSplit.length - 1].equalsIgnoreCase("htm");
    }

    @Override
    public String getDescription() {
        return  "HTML и HTM файлы";
    }
}
