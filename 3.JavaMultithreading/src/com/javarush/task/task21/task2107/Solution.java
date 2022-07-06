package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

        public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = age * 31;
            result = result + (name != null ? name.hashCode() : 0) * 31;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (this.getClass() != obj.getClass()) return false;
            User user = (User) obj;
            if (age != 0 ? age != (user.age) : user.age != 0) return false;
            if (name != null ? !name.equals(user.name) : user.name != null) return false;
            return true;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new User(this.age, this.name);
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Solution s = new Solution();

        if (this.users != null) {
            for (Map.Entry<String, User> m : this.users.entrySet()){
                String key = m.getKey();
                User value = m.getValue();
                s.users.put(key, (User) value.clone());// именно клонирование
            }
        }
        else s.users = null;

        return s;
    }
}
