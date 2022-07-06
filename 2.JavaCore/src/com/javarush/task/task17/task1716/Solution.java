package com.javarush.task.task17.task1716;

/* 
Синхронизированные методы
*/

public class Solution {
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() {//не меняет общие ресурсы
        Double d = method3();
    }

    protected void method1(String param1) {//не меняет общие ресурсы
        Solution solution = new Solution();
        solution.method0();
    }

    public void method2(int param1) {//не меняет общие ресурсы
        param1++;
    }

    synchronized double method3() {//меняет общие ресурсы
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    private synchronized void method4() { //меняет общие ресурсы
        sb.append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {//не меняет общие ресурсы
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public synchronized String method6(int param2) {//меняет общие ресурсы
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) {//не меняет общие ресурсы
        return "" + param2;
    }

    public static void main(String[] args) {

    }

}
