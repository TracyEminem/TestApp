package com.example.testlib.sort

object InsertionSort {

    fun <T:Comparable<T>> sort(array: Array<T>){
        for (i in array.indices){
            //将arr[i] 插入到合适的位置 ，arr[0,i)已经是有序的，arr[i,n]是未排序的
            for (j in i downTo 1){
                if(array[j].compareTo(array[j-1]) < 0){   //前后两两比较，换位置
                    swap(array,j,j-1)
                }else {
                    break
                }
            }
        }
    }

    //交换代表三次操作
    fun <T : Comparable<T>> swap(array: Array<T>,mCurrent: Int,mTarget: Int){
        var temp = array[mCurrent]
        array[mCurrent] = array[mTarget]
        array[mTarget] = temp
    }

//    /**
//     * 改进后的插入排序法 并没有改进时间复杂度仍然是T=O(n2)平方的时间复杂度
//     * @param arr
//     * @param <E>
//    </E> */
//    fun <E : Comparable<E>?> insertionSort(arr: Array<E>) {
//        for (i in arr.indices) {
//            //将arr[i]插入到合适的位置
//            val t = arr[i] //暂存
//            var j: Int
//            j = i
//            while (j > 0 && t!!.compareTo(arr[j - 1]) < 0) {
//
//                //一旦发现j不是要插入的元素位置，将j-1赋值给j
//                arr[j] = arr[j - 1]
//                j--
//            }
//            //循环结束，此时的j就应该是要插入的位置
//            arr[j] = t
//        }
//    }

//    fun <T : Comparable<T>?> sort2(array: Array<T>) {
//        for (i in array.indices) {
//            val t = array[i]
//            var j: Int
//            j = i
//            while (j - 1 >= 0 && t!!.compareTo(array[j - 1]) < 0) {
//                array[j] = array[j - 1]
//                j--
//            }
//            array[j] = t
//        }
//    }

    //交换，时间复杂度是不会变的，有序数组的时候，插入排序的复杂度是O(n)
    fun <T:Comparable<T>> sort2(array: Array<T>){
        for (i in array.indices){
            //将arr[i]暂存
            var temp = array[i]
            var j :Int = i
            while (j -1 >= 0 && temp.compareTo(array[j-1])<0){
                array[j] = array[j-1]
                j--
            }
            array[j] = temp
        }
    }

    //从右和左比，左边比右边大才需要交换位置。所以compareTo是大于
    fun <T:Comparable<T>> sortDown(array: Array<T>){
        for (i in array.indices.reversed()){
            var temp = array[i]
            var j:Int = i
            while (j+1 < array.size && temp.compareTo(array[j+1]) > 0){
                array[j] = array[j+1]
                j++
            }
            array[j] = temp
        }
    }

}