package com.example.testlib.sort;

public class InertSort {

    public static <T extends Comparable<T>> void sort(T[] array){

        for (int i = 0; i < array.length;i ++){
            T t = array[i];
            int j;
            for (j = i;j - 1 >= 0 && t.compareTo(array[j-1]) < 0;j--){
                array[j] = array[j-1];
            }
            array[j] = t;
        }

    }

}
