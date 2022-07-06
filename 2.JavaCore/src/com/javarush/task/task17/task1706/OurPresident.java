package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;
    private static final Object lock = new Object();  // создан для синхронизации
    private static boolean isInitialized = false;

    static {
        synchronized (lock) {
            if (!isInitialized) {
                if (president == null) {
                    president = new OurPresident();
                    isInitialized = true;
                }
            }
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
