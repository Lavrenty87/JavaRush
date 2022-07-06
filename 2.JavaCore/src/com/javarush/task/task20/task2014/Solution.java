package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
        String file = "D:/2014.txt";
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(file);
        Solution sSave = new Solution(5);
        sSave.saveObject(os);
        os.close();
        Solution sLoad = new Solution();
        sLoad.loadObject(is);
        is.close();
        System.out.println(sSave.string.equals(sLoad.string));


        System.out.println(new Solution(4));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution() {
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    public  void saveObject(OutputStream outputStream) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        out.writeObject(string);
    }

    public void loadObject(InputStream inputStream) throws IOException, ParseException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(inputStream);
        this.string =(String) in.readObject();
    }
}
