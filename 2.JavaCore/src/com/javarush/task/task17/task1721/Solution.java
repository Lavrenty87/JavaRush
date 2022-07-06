package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String failForAll = reader.readLine();
        String failForRemove = reader.readLine();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(failForAll))) {
            String str;
            allLines = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //forRemoveLines.forEach(System.out::println);
        try (BufferedReader br = Files.newBufferedReader(Paths.get(failForRemove))) {
            String str;
            forRemoveLines = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //forRemoveLines.forEach(System.out::println);
        Solution solution = new Solution();
        solution.joinData();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.size() >= forRemoveLines.size()) {

            for (int i = 0; i < forRemoveLines.size(); i++) {
                int count = 0;
                for (int j = 0; j < allLines.size(); j++) {
                    if (forRemoveLines.get(i).equals(allLines.get(j))) {
                        allLines.remove(j);
                        count ++;
                        j --;
                    }
                }
                if (count == 0) {
                    allLines.clear();
                    throw new CorruptedDataException();
                }
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
