package com.example.testapp.util

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.testapp.extension.datsStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.xml.sax.helpers.DefaultHandler

object DataStoreUtils {


//    fun <T> getSyncData(key:String,default: T):T{
//        val res = when(default){
//            is Long ->
//        }
//    }

    fun readStringData(key:String,default:String = ""):String{
        var value = ""
        runBlocking {
            datsStore.data.first {
                value = it[stringPreferencesKey(key)]?:default
                true
            }
        }
        return value
    }

    suspend fun saveStringData(key: String,value: String){
        datsStore.edit {
            mutablePreferences -> mutablePreferences[stringPreferencesKey(key)] = value
        }
    }

}