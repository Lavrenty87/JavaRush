package com.javarush.task.task32.task3208;

import java.rmi.RemoteException;

public class Cat implements Animal {
    public static final String UNIC_BINDING_NAME = "server.cat";

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void speak() throws RemoteException {
        System.out.println("meow");
    }

    @Override
    public void printName() throws RemoteException {
        System.out.print("Cat " + name + " ");
    }
}
