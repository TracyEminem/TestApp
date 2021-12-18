package com.example.testlib

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class TestMain {

    companion object{

        @JvmStatic
        fun main(args:Array<String>){
//            println("start a nice job")
//            var  test = TestMain()
////            test.test()
//            runBlocking {
//                test.test()
//            }
//            test.testa()

            var array = arrayOf(24,55,15,23,54,11,16,5)
//            var search = LinearSearch()
            println("${LinearSearch.search(array,16)}")

            var arrayStudent = arrayOf(Student("Alice",1),
                Student("Bobo",2), Student
            ("Charles",3), Student
            ("Jeremy",4), Student("Eminem",5)
            )
            println("${LinearSearch.search(arrayStudent,Student("Jeremy",4))}")
        }
    }













    private fun Long.date() = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this)

    private fun log(msg: String){
        println("[${System.currentTimeMillis().date()}]-[${Thread.currentThread().name}] $msg")
    }


    fun testa(){
        val scope = CoroutineScope(EmptyCoroutineContext)
        scope.launch {
            log("自定义作用域1")
        }
        val scope2 = object : CoroutineScope{
            override val coroutineContext: CoroutineContext
                get() = EmptyCoroutineContext
        }
        scope2.async {
            log("自定义作用域2")
        }
        Thread.sleep(200)
    }


    fun  t(){
        runBlocking {
            log("runBlocking 方式启动一个协程")
        }
        log("runBlocking1111 方式启动一个协程")
        GlobalScope.launch {
//            delay(199)
            log("runBlocking launch 方式启动一个协程")
        }
        log("runBlocking2222 方式启动一个协程")
        GlobalScope.async {
//            delay(100)
            log("runBlocking async 方式启动一个协程")
        }
        log("runBlocking3333 方式启动一个协程")
    }

    suspend fun test(){
        flowOf(1,3,4,5,6,)
            .take(3)
            .map {
                it * 2
            }.collect {
                println(it)
            }

    }


}