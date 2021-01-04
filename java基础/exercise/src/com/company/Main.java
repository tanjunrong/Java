package com.company;

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
        for (int i = 1;i<=10;i++){
            stringBuilder.append(i);
            
        }
        System.out.print(stringBuilder.toString());

    }
    public static boolean isOdd(int x){
        return (x^1) == (x-1);
    }
    public static double calculateA(int n){
        int i = 1;
        int sum=1;
        double res = 0;
        while(i<=n){
            sum*=i++;
            res +=1.0/sum;
        }
        return res;
    }

}

