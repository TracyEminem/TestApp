package com.example.testlib

import kotlin.jvm.Throws

data class Student(val name:String,val num:Int){


    override fun equals(other: Any?): Boolean {

        if(other == null) {
            return false
        }
        if(!this.javaClass.equals(other.javaClass))
            return false

        if(other === this){
            return true
        }

        return (other as Student).name == name
    }

}
