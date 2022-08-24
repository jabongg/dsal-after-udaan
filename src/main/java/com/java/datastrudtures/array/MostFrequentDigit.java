package com.java.datastrudtures.array;

public class MostFrequentDigit {

    public static void main(String[] args) {
        long number = 123456122;
        int []frequency = new int[10];

       // for number
//        while(number > 0)
//        {
//            int digit = (int) (number % 10);
//            number /= 10;
//            frequency[digit] ++;
//        }
//
//        for(int i = 0; i < 10; ++i)
//            System.out.print(frequency[i] + " ");




        // for string
        String str = "123423523972358230520237238523";
       // int []frequency = new int[10];
        for(int i = 0; i < str.length(); ++i)
        {
            int digit = str.charAt(i) - '0';
            frequency[digit]++;
        }
        for(int i = 0; i < 10; ++i)
            System.out.print(frequency[i] + " ");
    }
}
