package com.example.testlib.sort

object SelectionSort {

    //选择排序   每一轮排序都把还没处理的元素中间最小的拿出来  或者是取出最大的，从前往后或者从后往前都可以
    //1.排序过程占用了额外的空间(开辟了一个新的数组)，可否原地完成，原地排序
    fun makeSort(array:Array<Int>){

        for (mOuterIndex in 0 until array.size){
                    //选择 最小值的索引
                var mMinIndex = mOuterIndex
            for (mInnerIndex in mOuterIndex + 1 until array.size){
                if(array[mInnerIndex] < array[mMinIndex]){
                    mMinIndex = mInnerIndex
                }
            }
            swap(array,mOuterIndex,mMinIndex)
        }
    }

    fun swap(array: Array<Int>, mCurrent:Int, mTarget:Int){
        var temp = array[mCurrent]
        array[mCurrent] = array[mTarget]
        array[mTarget] = temp
    }


    //扩展为泛型，必须是实现Comparable接口的
    fun <T :Comparable<T>>
            sort(array:Array<T>){  //实现comparable接口表示可以比较的
        for (mOuter in 0 until array.size){
            var mIndex = mOuter
            for (mInner in mOuter + 1 until  array.size){
                if(array[mInner].compareTo(array[mIndex]) < 0){   //CompareTo返回整形，小于0代表小于，等于0代表相等，大于0代表大于
                    mIndex = mInner
                }
            }
            swap(array,mOuter,mIndex)
        }
    }

    fun <T : Comparable<T>> swap(array: Array<T>,mCurrent: Int,mTarget: Int){
        var temp = array[mCurrent]
        array[mCurrent] = array[mTarget]
        array[mTarget] = temp
    }

//    // 换个方法实现选择排序法，我们叫 sort2
//    fun <T : Comparable<T>> sort2(arr: Array<T>) {
//        for (i in arr.indices.reversed()) {
//
//            // 选择 arr[0...i] 中的最大值
//            var maxIndex = i
//            for (j in i downTo 0) {
//                if (arr[j]!!.compareTo(arr[maxIndex]) > 0) maxIndex = j
//            }
//            swap(arr, i, maxIndex)
//        }
//    }


    fun <T:Comparable<T>> sort2(array: Array<T>){
        for (mOuter in array.size-1 downTo 0 ){
            var mIndex = mOuter
            for (mInner in mOuter-1 downTo 0){
                if(array[mIndex].compareTo(array[mInner]) < 0 ){
                    mIndex = mInner
                }
            }
            swap(array,mOuter,mIndex)
        }
    }

}