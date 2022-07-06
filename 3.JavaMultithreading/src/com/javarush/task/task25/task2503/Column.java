package com.javarush.task.task25.task2503;

import java.util.*;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        TreeMap<Integer, Integer> rM = new TreeMap<>();

       // for (int i = 0; i < realOrder.length; i++) result.add()
        for (int i = 0; i < realOrder.length; i++) {
            if (realOrder[i] != -1) {
               // result.add(realOrder[i], Column.values()[i]);
                rM.put(realOrder[i], i);
            }
        }
        for (Map.Entry<Integer, Integer> m : rM.entrySet()) {
            Integer key = m.getKey();
            Integer value = m.getValue();
            result.add(Column.values()[value]);
        }
// javarush
       /* int nextIndex = 0;
        boolean hasNextElement = true;
        while (hasNextElement) {
            hasNextElement = false;
            for (int i = 0; i < realOrder.length; i++) {
                if (realOrder[i] == nextIndex) {
                    result.add(values()[i]);
                    break;
                }
            }
            for (int i = 0; i < realOrder.length; i++) {
                if (realOrder[i] == nextIndex + 1) {
                    hasNextElement = true;
                    nextIndex++;
                    break;
                }
            }
        }*/
        return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        int j = this.ordinal();
        if (Column.realOrder[j] != -1) return true;
        else return false;
    }

    @Override
    public void hide() {
         int a = this.ordinal();
         realOrder[a] = -1;

       /* int oldOrder = realOrder[ordinal()]; //javarush
        for (int i = 0; i < realOrder.length; i++) {
            int currentIndex = realOrder[i];
            if (currentIndex != -1 && currentIndex > oldOrder) {
                realOrder[i] -= 1;
            }
        }*/
    }
}
