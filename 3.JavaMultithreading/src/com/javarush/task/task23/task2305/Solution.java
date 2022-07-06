package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] s = new Solution[2];
        for (int i = 0; i < s.length; i++) {
            s[i] = new Solution();
            s[i].innerClasses[0] = new Solution().new InnerClass();
            s[i].innerClasses[1] = new Solution().new InnerClass();
        }
        return s;
    }

    public static void main(String[] args) {
        Solution[] d = getTwoSolutions();
        for (Solution a:d
             ) {
            System.out.println(a);
        }
    }
}
