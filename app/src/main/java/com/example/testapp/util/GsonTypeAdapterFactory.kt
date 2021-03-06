package com.example.testapp.util

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException

class GsonTypeAdapterFactory :TypeAdapterFactory{


    override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T> {
        val adapter = gson?.getDelegateAdapter(this,type)
        return object : TypeAdapter<T>(){
            override fun write(out: JsonWriter?, value: T) {
                adapter?.write(out, value)
            }
            @Throws(IOException::class)
            override fun read(jr: JsonReader): T? {
               return try {
                   adapter?.read(jr)
               }catch (e:Exception){
                   consumeAll(jr)
                   null
               }
            }
        }
    }

    @Throws(IOException::class)
    private fun consumeAll(jr: JsonReader){
        if(jr.hasNext()){
            val peek: JsonToken = jr.peek()
            when{
                peek === JsonToken.STRING -> {
                    jr.nextString()
                }
                peek === JsonToken.BEGIN_ARRAY -> {
                    jr.beginArray()
                    consumeAll(jr)
                    jr.endArray()
                }
                peek === JsonToken.BEGIN_OBJECT -> {
                    jr.beginObject()
                    consumeAll(jr)
                    jr.endObject()
                }
                peek === JsonToken.END_ARRAY -> {
                    jr.endArray()
                }
                peek === JsonToken.END_OBJECT -> {
                    jr.endObject()
                }
                peek === JsonToken.NUMBER -> {
                    jr.nextString()
                }
                peek === JsonToken.BOOLEAN -> {
                    jr.nextBoolean()
                }
                peek === JsonToken.NAME -> {
                    jr.nextName()
                    consumeAll(jr)
                }
                peek === JsonToken.NULL -> {
                    jr.nextNull()
                }
            }
        }
    }



}