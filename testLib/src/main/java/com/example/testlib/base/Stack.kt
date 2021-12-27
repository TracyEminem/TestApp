package com.example.testlib.base

interface Stack<T> {  //先进后出

    fun getSize():Int

    fun isEmpty():Boolean

    fun push(t:T)

    fun pop():T

    fun peek():T

}