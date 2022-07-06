package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
            if (telNumber!=null)
            if ((!telNumber.matches("[A-Z]|[a-z]|[А-Я]|[а-я]}"))) {
                if (telNumber.matches("^((\\+\\d{12})|([\\+]\\d{2}([\\(]([0-9]{3})[\\)]\\d{7}))|" +
                        "([\\+][0-9]{8}([\\-]\\d{2}){2})|(([0-9]{6})-\\d{4})|(\\d{10}))$")) {
                    return true;
                }
            }

        return false;
    }

    public static void main(String[] args) {
        String[] phoneNumber = {"+380501234567", "+38(050)1234567", "+38050123-45-67", "050123-4567", "+38)050(1234567",
                "+38(050)1-23-45-6-7", "050ххх4567", "050123456", "(0)501234567", null};
        for (String s : phoneNumber
             ) {
            System.out.println(checkTelNumber(s) + " - " + s);
        }
    }
}
