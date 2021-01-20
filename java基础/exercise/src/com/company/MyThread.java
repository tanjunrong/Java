package com.company;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.Arrays;

public class MyThread extends Thread {
    private int i = 10;

    public void run() {
        while (i > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i--);
        }
    }

    public static void main(String[] args) {
        new MyThread().start();

        Inet6Address inet4Address = null;
        try {
            inet4Address = (Inet6Address) Inet4Address.getByName("www.baidu.com");
            String localname = inet4Address.getHostName();
            String localip= inet4Address.getHostAddress();

            System.out.println(localname);
            System.out.println(localip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}

