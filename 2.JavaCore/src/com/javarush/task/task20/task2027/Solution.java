package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
               /* {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}*/
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'},
        };
//        for (int i = 0; i < crossword.length; i++) {
//            for (int j = 0; j < crossword[i].length; j++) {
//                System.out.print((char) crossword[i] [j] + "(" + crossword[i][j] + ")");
//            }
//            System.out.println();
//        }
        List<Word> words =detectAllWords(crossword, "home", "same", "kovhj", "pmluf", "fulmp","rr", "one");
        for (Word a :words
             ) {
            System.out.println(a);
        }
       // detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
попробовать вапиант из прошлого и с переворотом слова
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (int g = 0; g < words.length; g++) {
            char [] arrChar = words[g].toCharArray();

            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[y].length; x ++) {
                    if (crossword[y][x] == arrChar[0]) {
                       // System.out.println((char) crossword[y][x] + "(" + crossword[y][x] + ")");
                        // проверка сдвига по оси y со знаком +
                            if (y + arrChar.length - 1 < crossword.length) {
                                for (int i = 1; i < arrChar.length; i++) {
                                    if (crossword[y + i][x] != arrChar[i]) break;
                                    if (i == arrChar.length - 1) {
                                        Word w  = new Word(words[g]);
                                        w.setStartPoint(x, y);
                                        w.setEndPoint(x, y + arrChar.length - 1);
                                        list.add(w);
                                    }
                                }
                               /* if (crossword[y + 1][x] == arrChar[1] && crossword[y + arrChar.length - 1] [x] ==
                                arrChar[arrChar.length - 1]) {
                                    Word w  = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x, y + arrChar.length - 1);
                                    list.add(w);
                                    //System.out.println((char) crossword[y][x] + ", " + (char) crossword[y + arrChar.length - 1][x]);
                                }*/
                            }
                        // проверка сдвига по оси y со знаком -
                            if (y - (arrChar.length - 1) >= 0) {
                                for (int i = 1; i < arrChar.length; i++) {
                                    if (crossword[y - i][x] != arrChar[i]) break;
                                    if (i == arrChar.length - 1) {
                                        Word w = new Word(words[g]);
                                        w.setStartPoint(x, y);
                                        w.setEndPoint(x, y - (arrChar.length - 1));
                                        list.add(w);
                                    }
                                }
                                /*if (crossword[y - 1][x] == arrChar[1] && crossword[y - (arrChar.length - 1)][x] ==
                                arrChar[arrChar.length - 1]) {
                                    Word w = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x, y - (arrChar.length - 1));
                                    list.add(w);
                                   // System.out.println((char) crossword[y][x] + ", " + (char) crossword[y - arrChar.length - 1][x]);
                                }*/
                            }
                        // проверка сдвига по оси x со знаком +

                            if (x + arrChar.length - 1 < crossword[y].length) {
                                for (int i = 1; i < arrChar.length; i++) {
                                    if (crossword[y][x + i] != arrChar[i]) break;
                                    if (i == arrChar.length - 1) {
                                        Word w = new Word(words[g]);
                                        w.setStartPoint(x, y);
                                        w.setEndPoint(x + arrChar.length - 1, y);
                                        list.add(w);
                                    }
                                }
                                /*if (crossword[y][x + 1] == arrChar[1] && crossword[y] [x + arrChar.length - 1] ==
                                arrChar[arrChar.length - 1]) {
                                    Word w = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x + arrChar.length - 1, y);
                                    list.add(w);
                                    //System.out.println((char) crossword[y][x] + ", " + (char) crossword[y][x + arrChar.length - 1]);
                                }*/
                            }
                        // проверка сдвига по оси x со знаком -

                        if (x - (arrChar.length - 1) >= 0) {
                            for (int i = 1; i < arrChar.length; i++) {
                                if (crossword[y][x - i] != arrChar[i]) break;
                                if (i == arrChar.length - 1){
                                    Word w = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x - (arrChar.length - 1), y);
                                    list.add(w);
                                }
                            }
                            /*if (crossword[y][x - 1] == arrChar[1] && crossword[y] [x - (arrChar.length - 1)] ==
                                    arrChar[arrChar.length - 1]) {
                                Word w = new Word(words[g]);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x - (arrChar.length - 1), y);
                                list.add(w);
                                //System.out.println((char) crossword[y][x] + ", " + (char)crossword[y][x - arrChar.length - 1]);
                            }*/
                        }
                        // проверка сдвига по оси y x со знаком +
                        if (y + arrChar.length - 1 < crossword.length && x + arrChar.length - 1 < crossword[y].length) {
                            for (int i = 1; i < arrChar.length; i ++) {
                                if (crossword[y + i][x + i] != arrChar[i]) break;
                                if (i == arrChar.length - 1) {
                                    Word w = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x + arrChar.length - 1, y + arrChar.length - 1);
                                    list.add(w);
                                }
                            }
                            /*if (crossword[y + 1][x + 1] == arrChar[1] && crossword[y + arrChar.length - 1]
                                    [x + arrChar.length - 1] == arrChar[arrChar.length - 1]) {
                                Word w = new Word(words[g]);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x + arrChar.length - 1, y + arrChar.length - 1);
                                list.add(w);
                               // System.out.println((char) crossword[y][x] + ", " + (char) crossword[y - (arrChar.length - 1)][x - (arrChar.length - 1)]);
                            }*/
                        }
                        // проверка сдвига по оси y x со знаком -
                        if (y - (arrChar.length - 1) >= 0 && x - (arrChar.length - 1) >= 0) {
                            for (int i = 1; i < arrChar.length; i ++){
                                if (crossword[y - i][x - i] != arrChar[i]) break;
                                if (i == arrChar.length - 1) {
                                    Word w = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x - (arrChar.length - 1), y - (arrChar.length - 1));
                                    list.add(w);
                                }
                            }
                            /*if (crossword[y - 1][x - 1] == arrChar[1] && crossword[y - (arrChar.length - 1)]
                                    [x - (arrChar.length - 1)] == arrChar[arrChar.length - 1]) {
                                Word w = new Word(words[g]);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x - (arrChar.length - 1), y - (arrChar.length - 1));
                                list.add(w);
                                //System.out.println((char) crossword[y][x] + ", " + (char)crossword[y - (arrChar.length - 1)][x - (arrChar.length - 1)]);
                            }*/
                        }
                        // проверка сдвига по оси y со знаком + по оси x со знаком -
                        if (y + (arrChar.length - 1) < crossword.length && x - (arrChar.length - 1) >= 0) {
                            for (int i = 1; i < arrChar.length; i++) {
                                if (crossword[y + i][x - i] != arrChar[i]) break;
                                if (i == arrChar.length - 1) {
                                    Word w = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x - (arrChar.length - 1), y + (arrChar.length - 1));
                                    list.add(w);
                                }
                            }
                            /*if (crossword[y + 1][x - 1] == arrChar[1] && crossword[y + (arrChar.length - 1)]
                                    [x - (arrChar.length - 1)] == arrChar[arrChar.length - 1]) {
                                Word w = new Word(words[g]);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x - (arrChar.length - 1), y + (arrChar.length - 1));
                                list.add(w);
                                //System.out.println((char) crossword[y][x] + ", " + (char)crossword[y - (arrChar.length - 1)][x - (arrChar.length - 1)]);
                            }*/
                        }
                        // проверка сдвига по оси y со знаком - по оси x со знаком +
                        if (y - (arrChar.length - 1) >= 0 && x + (arrChar.length - 1) < crossword[y].length) {
                            for (int i = 1; i < arrChar.length; i ++) {
                                if (crossword[y - i][x + i] != arrChar[i]) break;
                                if (i == arrChar.length - 1) {
                                    Word w = new Word(words[g]);
                                    w.setStartPoint(x, y);
                                    w.setEndPoint(x + (arrChar.length - 1), y - (arrChar.length - 1));
                                    list.add(w);
                                }
                            }
                           /* if (crossword[y - 1][x + 1] == arrChar[1] && crossword[y - (arrChar.length - 1)]
                                    [x + (arrChar.length - 1)] == arrChar[arrChar.length - 1]) {
                                Word w = new Word(words[g]);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x + (arrChar.length - 1), y - (arrChar.length - 1));
                                list.add(w);
                                //System.out.println((char) crossword[y][x] + ", " + (char)crossword[y - (arrChar.length - 1)][x - (arrChar.length - 1)]);
                            }*/
                        }
                    }
                }
            }
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
