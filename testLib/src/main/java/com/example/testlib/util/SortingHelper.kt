package com.example.testlib.util

import com.example.testlib.sort.InsertionSort
import com.example.testlib.sort.SelectionSort
import java.lang.reflect.Method
import java.util.Comparator

object SortingHelper {


    //验证数组是否是有序的
    fun <T:Comparable<T>> isSorted(array: Array<T>):Boolean{  //必须实现Comparable接口
        for (index in 1 until array.size){
            if(array[index].compareTo(array[index-1]) < 0){
                return false
            }
        }
        return true
    }

    fun <T:Comparable<T>> SortTest(sortName:String,array: Array<T>){
//        var sortClass = Class.forName(sortName)
//        var method = sortClass.getMethod("sort",Array::class.java)
        var startTime = System.nanoTime()
        when(sortName){
            "InsertionSort" -> {
                InsertionSort.sort(array)
            }
            "SelectionSort" -> {
                SelectionSort.sort(array)
            }
        }
//        method.invoke(null,array)
        var endTime = System.nanoTime()
        var time = (endTime - startTime) / 1000000000.0
        if(!isSorted(array))
            throw RuntimeException(sortName+" failed")
        println("$sortName,${array.size},$time")
    }

//    fun <E : Comparable<E>?> sortTest(sortname: String, arr: Array<E>) {
//        try {
//            val sortClass = Class.forName(sortname)
//            val sortMethod: Method = sortClass.getMethod("sort", Array<Comparable>::class.java)
//            val params = arrayOf<Any>(arr)
//            val startTime = System.nanoTime()
//            sortMethod.invoke(null, params)
//            val endTime = System.nanoTime()
//            val time = (endTime - startTime) / 1000000000.0
//            if (!isSorted(arr)) throw RuntimeException("$sortname failed")
//            println(String.format("%s , n = %d : %f s", sortname, arr.size, time))
//        } catch (e: Exception) {
//            println(e.message)
//            e.printStackTrace()
//            println("Error in SortingHelper.sortTest!")
//        }
//    }

}