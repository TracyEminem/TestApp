package com.example.testlib.java;


public class Array<T> {

    private T[] data;
    private int size;

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    public void add(int index,T e){
//        if(size == data.length){
//            throw new IllegalArgumentException("Add failed.Array is full.");
//        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Wrong index");
        }
        if(size == data.length){
            resize(data.length * 2);
        }
        for (int i = size -1;i >= index;i--){
            data[i+1] = data[i];
        }
        data[index] =e;
        size++;
    }

    public void resize(int newCapacity){
        T[] arr = (T[]) new Object[newCapacity];
        for (int i = 0; i <size ; i++) {
            arr[i] = data[i];
        }
        data = arr;
    }

    public void addLast(T e){
        add(size,e);
    }

    public void addFirst(T e){
        add(0,e);
    }

    public T get(int index){
        if(index < 0 || index>= size){
            throw new IllegalArgumentException("Add failed.Wrong index");
        }
        return  data[index];
    }

    public void set(int index,T e){
        if(index < 0 || index>= size){
            throw new IllegalArgumentException("Add failed.Wrong index");
        }
        data[index] = e;
    }

    public boolean contains(T e){
        for (T t: data) {
            if(t.equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(T t){
        for (int i = 0; i < size; i++) {
            if(t.equals(data[i])){
                return i;
            }
        }
        return  -1;
    }

    public T remove(int index){
        if(index < 0 || index>= size){
            throw new IllegalArgumentException("Add failed.Wrong index");
        }
        T result = data[index];
        for (int i = index+1; i < size; i--) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;//loitering objects != memory leak
        if(size == data.length / 4 && data.length /2 != 0){ //Lazy
            resize(data.length / 2);
        }
        return result;
    }

    public T removeLast(){
        return remove(size-1);
    }

    public void removeElement(T t){
        int index = find(t);
        if(index != -1){
            remove(index);
        }
    }

    public T getLast(){
        return get(size -1);
    }

    public T getFirst(){
        return get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Array:size="+size+",capacity="+data.length);
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size -1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

}
