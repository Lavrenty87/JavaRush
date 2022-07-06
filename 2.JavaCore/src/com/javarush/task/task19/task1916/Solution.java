package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedReader readFile1 = null;
        BufferedReader readFile2 = null;
        ArrayList<String> listF1 = new ArrayList<>();
        ArrayList<String> listF2 = new ArrayList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            readFile1 = new BufferedReader(new FileReader(file1));
            readFile2 = new BufferedReader(new FileReader(file2));
            while (readFile1.ready()) {
                listF1.add(readFile1.readLine());
            }
            while (readFile2.ready()) {
                listF2.add(readFile2.readLine());
            }
            initLines(listF1, listF2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(reader).close();
                Objects.requireNonNull(readFile1).close();
                Objects.requireNonNull(readFile2).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Метод для заполнения Lines
    public static void initLines(ArrayList<String> list1, ArrayList<String> list2) {
        int andLastI = 0;
        int andLastJ = 0;
        // если листы одинаковой длины
       // if (list1.size() == list2.size()){
            for (int  i = 0, j = 0; j < list2.size(); i++, j++) {
                if (i == list1.size()) break;
                if (list1.get(i).equals(list2.get(j))) lines.add(new LineItem(Type.SAME, list1.get(i)));
                else if (list1.get(i + 1).equals(list2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    j--;
                } else if (list1.get(i).equals(list2.get(j + 1))) {

                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    i--;
                }
                andLastI = i;
                andLastJ = j;
              //  System.out.println(lines.get(lines.size()-1).type + ", " + lines.get(lines.size()-1).line);
            }
            // если прервались из-за 1 лита то всу что осталось ADDED
            if (andLastJ != list2.size() - 1) {
                for (int i = andLastJ + 1; i < list2.size(); i++) {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    System.out.println(lines.get(lines.size() - 1).type + ", " + lines.get(lines.size() - 1).line);
                }
            } if (andLastI != list1.size() - 1){
                // если прервались из-за 2 лита то всу что осталось REMOVED
                for (int i = andLastI + 1; i < list1.size(); i++) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                   // System.out.println(lines.get(lines.size() - 1).type + ", " + lines.get(lines.size() - 1).line);
                }
          //  }
           /* //
        } else if (list1.size() > list2.size()) {
            for (int  i = 0, j = 0; j < list2.size(); i++, j++) {
                if (list1.get(i).equals(list2.get(j))) lines.add(new LineItem(Type.SAME, list1.get(i)));
                else if (list1.get(i + 1).equals(list2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    j--;
                } else if (list1.get(i).equals(list2.get(j + 1))) {

                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    i--;
                }
                andLastI = i;
            }
                for (int i = andLastI + 1; i < list1.size(); i++)
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
        } else {
            for (int  i = 0, j = 0; i < list1.size(); i++, j++) {
                if (list1.get(i).equals(list2.get(j))) lines.add(new LineItem(Type.SAME, list1.get(i)));
                else if (list1.get(i + 1).equals(list2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    j--;
                } else if (list1.get(i).equals(list2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    i--;
                }
                andLastI = j;
            }
            for (int i = andLastI + 1; i < list2.size(); i++)
                lines.add(new LineItem(Type.ADDED, list2.get(i)));*/
        }
       // System.out.println("-------");
      //  for (LineItem a : lines) System.out.println(a.type + ", " + a.line);
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
