package com.example.testlib.sort

data class Students(val name:String,val score:Int):Comparable<Students>{

    override fun compareTo(other: Students): Int {
      return this.score - other.score    //最佳写法
    }

    override fun toString(): String {
        return String.format("Studen(name:$name,score:$score)")
    }

}
