package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        super.run();
        String s = thread.getState().toString();
        System.out.println(s);
        while (!s.equals("TERMINATED")) {
            if (!(s.equals(thread.getState().toString()))) {
                s = thread.getState().toString();
                System.out.println(s);
            }
        }
        // javaRush
        /* State currentState = thread.getState();
        System.out.println(currentState);

        State newState;
        do {
            if ((newState = thread.getState()) != currentState) {
                currentState = newState;
                System.out.println(newState);
            }
        } while (!currentState.equals(State.TERMINATED));
    }*/
    }


}
