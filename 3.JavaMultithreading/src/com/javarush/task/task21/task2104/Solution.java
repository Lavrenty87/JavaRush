package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Solution n = (Solution) o;
        if (first != null ?!first.equals( n.first) : n.first != null) return false;
        if (last != null ? !last.equals(n.last) : n.last != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int p = 31;
        int result = 1;

        result = first != null ?  (first.hashCode() + result) * p : 0;
        result = last != null ? (last.hashCode() + result) * p : 0;
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

    }
}
