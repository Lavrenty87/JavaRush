package com.javarush.task.task28.task2805;

public class MyThread extends Thread {

    /*
    private static volatile AtomicInteger priority = new AtomicInteger(1);

    private synchronized void correctPriority() {
        int newPriority = priority.getAndIncrement();
        newPriority = getThreadGroup() != null && newPriority > getThreadGroup().getMaxPriority() ? getThreadGroup().getMaxPriority() : newPriority;
        setPriority(newPriority);
        if (priority.intValue() > MAX_PRIORITY) {
            priority.set(1);
        }*/
    public static int p = 1;
    public synchronized void initP () {
        p++;
        if (p > 10) p = 1;
    }

    public MyThread() {
        this.setPriority(p);
        initP();
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(p);
        initP();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (group.getMaxPriority() > p) {
            this.setPriority(p);
        } else this.setPriority(group.getMaxPriority());
        initP();
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(p);
        initP();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (group.getMaxPriority() > p) {
            this.setPriority(p);
        } else this.setPriority(group.getMaxPriority());
        initP();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(p);
        initP();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (group.getMaxPriority() > p) {
            this.setPriority(p);
        } else this.setPriority(group.getMaxPriority());
        initP();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (group.getMaxPriority() > p) {
            this.setPriority(p);
        } else this.setPriority(group.getMaxPriority());
       initP();
    }
}
