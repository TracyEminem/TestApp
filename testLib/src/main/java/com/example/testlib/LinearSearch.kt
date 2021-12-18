package com.example.testlib

object LinearSearch {

    //线性查找
    fun search(data:Array<Int>,target:Int):Int{
        for (index in 0 until  data.size){
            if(data[index] == target)
                return index
        }
        return -1
    }

    //包装成泛型来扩大使用范围
    fun <T> search(data:Array<T>,target:T):Int{
        for (index in 0 until  data.size){
            if(data[index]!!.equals(target))  //需要在对应的泛型类中实现equals方法,默认比较的是地址
                return index
        }
        return -1
    }

}