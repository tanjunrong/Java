package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Main {

    static int age = 15;

    public static void main(String[] args) {
        // write your code here

//        int name[] = {15, 18, 20, 23};
//        for (int x : name
//        ) {
//            System.out.println(isOdd(x));
//
//        }
//        final int size = 11;
//        int midX = size/2 + 1;
//        int midY = size/2 + 1;
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if(i+j>=5 && i+j<=15 && j-i>=-5 && j-i<=5){
//                    System.out.print("*");
//                }else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//
//        }
        String s = new String("1213132123");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 1; i <= 10; i++) {
            stringBuilder.append(i);

        }
        System.out.print(stringBuilder.toString());
        for (String str : args
        ) {
            System.out.println(str);

        }

    }

    public static boolean isOdd(int x) {
        return (x ^ 1) == (x - 1);
    }

    public static double calculateA(int n) {
        int i = 1;
        int sum = 1;
        double res = 0;
        while (i <= n) {
            sum *= i++;
            res += 1.0 / sum;
        }
        return res;
    }

}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name() default "MyAnnotation";

    int id() default -1;

    String[] paras() default {"参数类型", "参数名()"};
}
