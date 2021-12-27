package com.example.testlib.base

import kotlin.Array

class Array {
    var size :Int = 1
    lateinit var Data:IntArray
//    var array:Array<T> =

    constructor(capacity:Int){
        size = 0
        Data = IntArray(capacity)
    }

    constructor(){
        Data = IntArray(10)
    }

    fun getCapacity():Int{
        return Data.size
    }

    fun isEmpty():Boolean{
        return size == 0
    }

    fun addFirst(e:Int){
        add(0,e)
    }

    fun addLast(e:Int){
//        if(size == Data.size)
//            throw IllegalArgumentException("AddLast failed.Array is full")
//        Data[size] = e
//        size++
        add(size,e)
    }

    fun add(index:Int,e:Int){
        if(size == Data.size)
            throw IllegalArgumentException("AddLast failed.Array is full，$size")
        if(index <0 || index > size){
            throw IllegalArgumentException("AddLast failed.Array is full，$size")
        }
//        IntArray[index] = e
//        size++
        for (i in  size-1 downTo index){
            Data[i+1] = Data[i]
        }
        Data[index] = e
        size++
    }

    fun get(index: Int):Int{
        if(index <0 || index >= size){
            throw IllegalArgumentException("Get Failed,Index is illegal")
        }
        return Data[index]
    }

    fun set(index: Int,e: Int){
        if(index <0 || index >= size){
            throw IllegalArgumentException("Get Failed,Index is illegal")
        }
        Data[index] = e
    }

    //只删除一个，如果有重复的没有删除光
    fun removeElement(e: Int){
        var index = findIndex(e)
        if(index !=1){
            remove(index)
        }
    }

    fun contains(e: Int):Boolean{
        for (index in 0 until size){
            if(Data[index] == e){
                return true
            }
        }
        return false
    }

    fun removeFirst():Int{
        return remove(0)
    }

    fun removeLast():Int{
        return remove(size-1)
    }

    fun remove(index: Int):Int{
        if(index <0 || index >= size){
            throw IllegalArgumentException("Get Failed,Index is illegal")
        }
        var data = Data[index]
        for (i in index+1 until size){
            Data[i -1]=Data[i]
        }
        size --
        return data
    }

    fun findIndex(e: Int):Int{
        for (index in 0 until size){
            if (Data[index] == e){
                return index
            }
        }
        return -1
    }

    override fun toString(): String {
        var res = StringBuilder()
        res.append("Array:size=$size,capacity=${Data.size}")
        res.append("[")
        for (index in 0 until  size){
            res.append("${Data[index]}")
            if(index != size-1){
                res.append(",")
            }
        }
        res.append("]")
        return res.toString()
    }


    companion object{

        @JvmStatic
        fun main(args:Array<String>) {

            var arr = Array(20)
            for (index in 0 .. 10){
                arr.addLast(index)
            }
            println(arr)
            arr.remove(2)
            println(arr)
            }
        }

}