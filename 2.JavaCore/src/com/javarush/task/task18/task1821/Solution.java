package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            HashSet<Character> check = new HashSet<>();
            TreeMap<Integer, Integer> result = new TreeMap<>();
            FileInputStream fis = new FileInputStream(args[0]);
            char[] arr = new char[fis.available()];
          for (int i = fis.available()-1; i > -1; i --) {
              arr[i] = (char) fis.read();
              check.add(arr[i]);
          }
            for (int i = 0 ; i < arr.length; i++) {//System.out.println((int) arr[i] + "__" + (char) arr[i]);
                if (check.contains(arr[i])) {
                    int data = 1;
                    for (int j = i+1; j < arr.length; j++) {
                        if (arr[i] == arr[j]) data++;
                    }

                    result.put((int)arr[i], data);
                    check.remove(arr[i]);
                }
            }
            for (Map.Entry<Integer, Integer> p : result.entrySet()) {
                int k = p.getKey();
                int v = p.getValue();
                System.out.println((char) k +  " " + v + " - " + k);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
1
Усложни себе жизнь сам.

Задача за 5 минут решается через TreeMap, данная структура данных автоматически отсортирует Вам ключи по коду ASCII.
Если кому надо, то порядок действий:
1) Создаем необходимый FileInputStream с нужным параметром, создаем ArrayList, создем TreeMap.
2) считываем поток и в том же цикле добавляем его в ArrayList.
3) проходимся по arrayList с помощью for each. В нём создаем переменную-счётчик, которая count=Collections.frequency(dataArray, i);
В этом же цикле добавляем в нашу мапу значения: dataMap.put((char) i, count);
4) следующим for each выводим значения в консоль.

И самое обидное: код, описанный выше написал за 5 минут, никаких проблем. Но мой мозг почему-то решил, что сортировать надо не
по ASCII, а по частоте повторений. И битый час искал способ отсротировать TreeMap по значению, а не по ключу. Да, такого способа не существует.

2

А зачем лишний ArrayList создавать? Задача и при помощи одного лишь TreeMap решается же.

3

А я вообще не создавал ни коллекций, ни массива лишнего... Валидатор принял.
Считал файл в буфер byte[] buffer. Закрыл поток. Переменная-счетчик. А потом просто вложенный цикл. Внешний for i от 0 до 126 (валидатор принял именно от 0, хотя до 32 вроде как непечатные символы) - это уже готовая сортировка. А во вложенном foreach сравниваем байты buffer с текущим i и увеличиваем счетчик.
Закрываем вложенный цикл, и печатаем результат, если счетчик не нулевой. Обнуляем счетчик.
 */