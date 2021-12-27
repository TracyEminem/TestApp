package com.example.testlib.algorithm

import com.example.testlib.base.ArrayStack
import java.util.*

object VaildParentheses {  //括号匹配

//    fun isValid1(content:String):Boolean{  //错误
//
//        var stack = ArrayStack<String>()
//        var data = content.toCharArray()
//        for (i in 0 until data.size){
//            var c = data.get(i)
//            if(c.equals("{") ||c.equals("[") ||c.equals("(") ){
//                stack.push(c.toString())
//            }else{
//                if(stack.isEmpty())
//                    return  false
//                var topChar = stack.peek().toString()
//                if(c.equals("(") && !topChar.equals(")")){
//                    return false
//                }else if(c.equals("{") && !topChar.equals("}")){
//                    return false
//                }else if(c.equals("[") && !topChar.equals("]")){
//                    return false
//                }
//            }
//
//        }
//        return stack.isEmpty()
//    }

    fun isValid(s:String):Boolean{  //"()"
        var stack = Stack<String>()
        var data = s.toCharArray()
        data.forEach {
            if(it.toString().equals("{") ||it.toString().equals("[") ||it.toString().equals("(") ){
                stack.push(it.toString())
            }else {
                if(stack.isEmpty())
                    return false
                var topChar = stack.pop()
                if(it.toString().equals(")") && !topChar.equals("(")){
                    return false
                }else if(it.toString().equals("}") && !topChar.equals("{")){
                    return false
                }else if(it.toString().equals("]") && !topChar.equals("[")){
                    return false
                }
            }
        }
        return stack.isEmpty()
    }

}