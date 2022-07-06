package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {

        public TableInterface originalTI;

        public TableInterfaceWrapper(TableInterface originalTI) {
            this.originalTI = originalTI;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());// реализоать
            originalTI.setModel(rows);//запустить
        }

        @Override
        public String getHeaderText() {
            return originalTI.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            originalTI.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

    void setHeaderText(String newHeaderText);
}

public static void main(String[] args) {

}
}