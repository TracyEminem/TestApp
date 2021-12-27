package com.example.testlib.base

import com.example.testlib.java.Array;
import java.security.DrbgParameters

class ArrayStack<T> : Stack<T> {  //栈中间的元素是无法知道和可见的，也是不可操作的

   lateinit var array:Array<T>;

    constructor(){
        array = Array()
    }

   constructor(capability: Int){
       array = Array(capability)
   }

    override fun getSize(): Int {
        return array.size
    }

    override fun isEmpty(): Boolean {
        return array.isEmpty
    }

    override fun push(t: T) {
        array.addLast(t)
    }

    override fun pop(): T {
       return array.removeLast();
    }

    //peek只获取不删除，POP会删除
    override fun peek(): T {
        return array.getLast()
    }

    override fun toString(): String {
//        return super.toString()
        var res = StringBuilder()
        res.append("Stack: ")
        res.append("[")
        for (i in 0 until array.size){
            res.append("${array[i]}")
            if(i != array.size-1){
                res.append(", ")
            }
        }
        res.append("] top")
        return res.toString()
    }

}