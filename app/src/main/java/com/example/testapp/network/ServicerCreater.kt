package com.example.testapp.network

import android.os.Build
import com.example.testapp.extension.screenPixel
import com.example.testapp.util.GlobalUtil
import com.example.testapp.util.GsonTypeAdapterFactory
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*

object ServicerCreater {

    const val BASE_URL = "http://baobab.kaiyanapp.com/"


    val httpClient = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor())
        .addInterceptor(HeaderInterceptor())
        .addInterceptor(BasicParamsInterceptoer())
        .build()

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().registerTypeAdapterFactory(GsonTypeAdapterFactory()).create()))
        .addConverterFactory(ScalarsConverterFactory.create())

    class LoggingInterceptor:Interceptor{

        override fun intercept(chain: Interceptor.Chain): Response {
            val  request = chain.request()
            val  t1 = System.nanoTime()

            val response = chain.proceed(request)
            val t2 = System.nanoTime()
            return response
        }
        companion object {
            const val TAG = "LoggingInterceptor"
        }
    }

    class HeaderInterceptor : Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val origin = chain.request()
            val request = origin.newBuilder().apply {
                header("model","Android")
                header("If-Modified-Since","${Date()}")
                header("User-Agent",System.getProperty("http.agent")?:"unkown")
            }.build()
            return chain.proceed(request)
        }
    }

    class BasicParamsInterceptoer:Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val originRequest = chain.request()
            val originHttpUrl = originRequest.url()
            val url = originHttpUrl.newBuilder().apply {
                addQueryParameter("udid", GlobalUtil.getDeviceSerial())
                addQueryParameter("vc", GlobalUtil.eyepetizerVersionCode.toString())
                addQueryParameter("vn", GlobalUtil.eyepetizerVersionName)
                addQueryParameter("size", screenPixel())
                addQueryParameter("deviceModel", GlobalUtil.deviceModel)
                addQueryParameter("first_channel", GlobalUtil.deviceBrand)
                addQueryParameter("last_channel", GlobalUtil.deviceBrand)
                addQueryParameter("system_version_code", "${Build.VERSION.SDK_INT}")
            }.build()
            val request = originRequest.newBuilder().url(url).method(originRequest.method(),originRequest.body()).build()
            return chain.proceed(request)
        }

    }

}