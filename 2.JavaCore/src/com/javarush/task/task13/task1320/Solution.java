package com.javarush.task.task13.task1320;

/* 
Neo
*/

import org.omg.CosNaming.NamingContextExtOperations;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject {
         DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }

        @Override
        public User initializeIdAndName(long id, String name) {// так выпоняется условие в пунктах 2,3
            this.id = id;
            this.name = name;
            return this;
        }

      /*  @Override
        public DBObject initializeIdAndName(long id, String name) {// так НЕ! выпоняется условие в пунктах 2,3
            this.id = id;
            this.name = name;
            return this;
        }*/
    }
}
