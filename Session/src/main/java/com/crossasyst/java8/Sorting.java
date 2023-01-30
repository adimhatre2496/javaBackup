package com.crossasyst.java8;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        int number[]={20,12,14,1,19,51,60,4,8};

        Arrays.sort(number);

        for (int i = 0; i < number.length; i++)
        {
            System.out.println(number[i]);
        }
    }
}
