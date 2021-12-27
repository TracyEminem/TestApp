package com.example.testlib

import com.example.testlib.algorithm.VaildParentheses
import com.example.testlib.base.ArrayStack
import com.example.testlib.sort.InsertionSort
import com.example.testlib.sort.SelectionSort
import com.example.testlib.sort.Students
import com.example.testlib.util.SortingHelper
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
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


            //查找，不是排序，只是找到相等的类型的下标
//            var array = arrayOf(24,55,15,23,54,11,16,5)
//            var search = LinearSearch()

            var startTime = System.nanoTime()
            var array = ArrayGenerator.GeneratOrderedArray(10000)
            println("---------------线性查找------------------")
            println("${LinearSearch.search(array,16)}")
            var endTime = System.nanoTime()
            println("---------------时间测试------------------")
            println("${(endTime-startTime)/100000000.0}")

            println("---------------Begin of selectionsort------------------")
            var intArray = arrayOf(111,24,55,1,32,0,99,15,23,54,11,16,5)
            SelectionSort.sort(intArray)
            intArray.forEach {
                print("${it},")
            }
            println()
            println("---------------end of selectionsort------------------")

            var arrayStudent = arrayOf(Student("Alice",1),
                Student("Bobo",2), Student
            ("Charles",3), Student
            ("Jeremy",4), Student("Eminem",5)
            )
            println("${LinearSearch.search(arrayStudent,Student("Jeremy",4))}")


            println("---------------Selection 泛型------------------")
            var arrayStudents = arrayOf(
                Students("Alice",89),
                Students("Bobo",31), Students
                    ("Charles",94), Students
                    ("Jeremy",78), Students("Eminem",57)
            )
            SelectionSort.sort(arrayStudents)
            arrayStudents.forEach {
                println("${it}")
            }
            println("---------------生成随机数数组-----------------")
            var temp = ArrayGenerator.GeneratRandomArray(60,1000)
            SelectionSort.sort(temp)
            temp.forEach {
                print("${it},")
            }
            println()
            //验证排序算法是不是有序的
            println("${SortingHelper.isSorted(temp)}")

            println("-----------------从后往前排------------------")
            var temp2 = ArrayGenerator.GeneratRandomArray(30,1000)
            SelectionSort.sort2(temp2)
            temp2.forEach {
                print("${it},")
            }
            println()
            println("-----------------SortingHelper------------------")
            var temp3 = ArrayGenerator.GeneratRandomArray(20,1000)
            SortingHelper.SortTest(SelectionSort.javaClass.simpleName,temp3)
            temp3.forEach {
                print("${it},")
            }
            println()
            println("-----------------InsertingHelper------------------")
            var tem4 = ArrayGenerator.GeneratRandomArray(10,1000)
            InsertionSort.sortDown(tem4)
            tem4.forEach {
                print("${it},")
            }
            println()


            val arr: com.example.testlib.java.Array<Students> = com.example.testlib.java.Array()
            for (index in  1..20){
                arr.addLast(Students("Alice", 100))
                arr.addLast(Students("Bob", 66))
                arr.addLast(Students("Charlie", 88))
            }
            println(arr)


            var stack = ArrayStack<Int>()
            for (i in 0 until 5){
                stack.push(i)
                println(stack)
            }
            stack.pop()
            println(stack)


            VaildParentheses.isValid("(]")
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
        flowOf(1, 3, 4, 5, 6)
            .take(3)
            .map {
                it * 2
            }.collect {
                println(it)
            }

    }


}