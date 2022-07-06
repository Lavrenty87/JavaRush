package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args.length > 3) {
            if (args[0].equals("-c")) {
                String idProduct, productName = null, prise, quantity;
                reader.close();
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                ArrayList<Integer> listId = new ArrayList<>();
                while (fileReader.ready()) {
                    String a = fileReader.readLine();
                    String id = a.substring(0, 8);
                    if (id.contains(" ")) {
                        id = id.substring(0, id.indexOf(" "));
                        listId.add(Integer.parseInt(id));
                    }else listId.add(Integer.parseInt(id));
                }
                fileReader.close();

                int max = Collections.max(listId) + 1;
                idProduct = String.valueOf(max);
                while (idProduct.length() < 8) {
                    idProduct += " ";
                }

                for (int i = 1; i < args.length - 2; i++) {
                    if (!(productName == null)) {
                        productName += args[i];
                    }
                    else productName = args[i];
                }
                while (productName.length() < 30) {
                    productName += " ";
                }
                if (productName.length() > 30) productName = productName.substring(0, 30);

                prise = args[args.length - 2];
                while (prise.length() < 8) {
                    prise += " ";
                }
                if (prise.length() > 8) prise = prise.substring(0, 8);

                quantity = args[args.length - 1];
                while (quantity.length() < 4) {
                    quantity += " ";
                }
                if (quantity.length() > 4) quantity = quantity.substring(0, 4);

                FileOutputStream fileWrite = new FileOutputStream(fileName, true);
                String strWriteFile = idProduct + productName + prise + quantity;
                fileWrite.write(("\n" + strWriteFile).getBytes());
                fileWrite.close();
            }
        }
    }
}
