package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    StringBuilder stringBuilder = new StringBuilder();
    private int x;
    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int result = x % 2;
        int forRecursiveTask = x / 2;
        if (forRecursiveTask > 0) {
            BinaryRepresentationTask doIt = new BinaryRepresentationTask(forRecursiveTask);
            doIt.fork();
            return doIt.join() + result;
        }
        return String.valueOf(result);
    }
}

