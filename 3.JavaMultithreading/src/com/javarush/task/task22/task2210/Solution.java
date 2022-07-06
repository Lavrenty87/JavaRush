package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;/*
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] s = new String[tokenizer.countTokens()];
        for (int i = 0; i < s.length; i++) s[i] = tokenizer.nextToken();
        return s;
    }
}
