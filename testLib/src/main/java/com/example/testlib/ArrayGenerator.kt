package com.example.testlib

import kotlin.random.Random

object ArrayGenerator {

    //制造顺序数组
    fun GeneratOrderedArray(n:Int):Array<Int>{
        var array = IntArray(n)
        for (index in 0 until n){
            array[index] = index
        }
        return array.toTypedArray()
    }

    fun GeneratRandomArray(mSize :Int,mUntil:Int):Array<Int>{
        var array = IntArray(mSize)
        for (index in 0 until mSize){
            array[index] = Random.nextInt(mUntil)  //随机数最大值
        }
        return array.toTypedArray()
    }

}