package com.bitchpeng.thread.lock;

public class SortTest {

    private static SortTest INSTANCE;

    private SortTest() {
    }

    public static SortTest getInstance() {
        if (INSTANCE == null) {
            synchronized (SortTest.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SortTest();
                }
            }
        }
        return INSTANCE;
    }

}
