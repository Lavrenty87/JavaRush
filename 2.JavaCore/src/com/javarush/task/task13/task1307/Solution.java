package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {

        SimpleObject<T> getInstance();
    }

    class StringObject /*допишите здесь ваш код*/ implements SimpleObject<String> {
        private String a;
        StringObject(String a){
            this.a = a;
        }

        @Override
        public  SimpleObject<String> getInstance() {
            this.a = a;
            return null;
        }
    }
}