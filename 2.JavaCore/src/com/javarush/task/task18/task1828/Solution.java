package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strFile = new ArrayList<>();

        BufferedReader redFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = redFileName.readLine();
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        redFileName.close();

        while (readFile.ready()) {
            strFile.add(readFile.readLine());
        }
        switch (args[0]) {
            case ("-u") :
                for (int i = 0; i < strFile.size(); i++) {
                    String id1 = strFile.get(i).substring(0, 8);
                    id1 = id1.trim();
                    if (id1.equals(args[1])) {

                        String id = strFile.get(i).substring(0, 8);
                        String productName  = null;
                        for (int j = 2; j < args.length - 2; j++) {
                            if (!(productName == null)) {
                                productName += " " + args[j];
                            }
                            else productName = args[j];
                        }
                        while (productName.length() < 30) {
                            productName += " ";
                        }
                        if (productName.length() > 30) productName = productName.substring(0, 30);

                        String prise = args[args.length - 2];
                        while (prise.length() < 8) {
                            prise += " ";
                        }
                        if (prise.length() > 8) prise = prise.substring(0, 8);

                        String quantity = args[args.length - 1];
                        while (quantity.length() < 4) {
                            quantity += " ";
                        }
                        if (quantity.length() > 4) quantity = quantity.substring(0, 4);
                        String newStr = id + productName + prise + quantity;
                        strFile.set(i, newStr);
                        break;
                    }
                }
                break;
            case  ("-d") :
                for (int i = 0; i < strFile.size(); i++) {
                    if (strFile.get(i).substring(0, args[1].length()).equals(args[1])) {
                        strFile.remove(i);
                        break;
                    }
                }
                break;
        }
        readFile.close();
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < strFile.size(); i++) {
            if (i == 0) writerFile.write(strFile.get(i));
            else {
                writerFile.newLine();
                writerFile.write(strFile.get(i));
            }
        }
        writerFile.close();
    }
}
