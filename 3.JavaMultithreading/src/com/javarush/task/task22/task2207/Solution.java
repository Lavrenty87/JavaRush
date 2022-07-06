package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/*
D:\JavaRush\TeatTask2207\text.txt
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

        try (BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName.readLine())))) {

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
            sb.append(reader.readLine()).append(" ");
        }

            String[] strings = sb.toString().split(" ");
            HashMap<String, Integer> wordCount = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < strings.length; i++) {
                String s;
                int count = 0;
                if (!wordCount.containsKey(strings[i])) {
                    set.add(strings[i]);
                    s = strings[i];
                    count++;
                    for (int j = i + 1; j < strings.length; j++) {
                        if (s.equals(strings[j])) count++;
                    }
                    wordCount.put(s, count);

                }
            }

            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                String sam = String.valueOf(iterator.next());
                if (wordCount.containsKey(sam)){
                    int value = wordCount.get(sam);
                    if (sam.equals(String.valueOf( new StringBuilder(sam).reverse()))) {
                        if (value > 1) {
                            int countPars = value/2;
                            for (int i =0; i < countPars; i++) {
                                Pair p = new Pair();
                                p.first = sam;
                                p.second = sam;
                                result.add(p);
                            }
                            wordCount.remove(sam);
                        }
                    } else {
                        String a = new StringBuilder(sam).reverse().toString();
                        if (wordCount.containsKey(a)){
                            int aInt = wordCount.get(a);
                            if (value <= aInt){
                                for (int i = 0; i < value; i++) {
                                    Pair p = new Pair();
                                    p.first = sam;
                                    p.second = a;
                                    result.add(p);
                                }
                                wordCount.remove(sam);
                                wordCount.remove(a);
                            } else {
                                for (int i = 0; i < aInt; i++) {
                                    Pair p = new Pair();
                                    p.first = sam;
                                    p.second = a;
                                    result.add(p);
                                }
                                wordCount.remove(sam);
                                wordCount.remove(a);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Pair p : result
             ) {
            System.out.println(p.first + " " + p.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
