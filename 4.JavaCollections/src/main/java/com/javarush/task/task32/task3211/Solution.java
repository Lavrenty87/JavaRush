package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println( compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigestStrim = null;
        messageDigestStrim = MessageDigest.getInstance("MD5");
        messageDigestStrim.update(byteArrayOutputStream.toByteArray());

        byte[] mdsByte = messageDigestStrim.digest();
        StringBuffer sbS = new StringBuffer();
        for (int i = 0; i < mdsByte.length; i++) {
            //String s = Integer.toHexString(mdsByte[i]);
            String s = Integer.toHexString(0xff & mdsByte[i]);
            s = (s.length() == 1) ? "0" + s : s;
            sbS.append(s);
        }

        System.out.println(md5 + "    " + sbS.toString());
        return md5.equals(sbS.toString());
    }
}
