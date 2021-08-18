package com.hapmate.simpledaggerexample.di.interceptor


import android.util.Log
import com.optisol.dagger2example.config.SessionManager

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthTokenInterceptor(private val sessionManager: SessionManager) : Interceptor {

    private var requestBuilder: Request.Builder? = null

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        try {

            val original = chain.request()
            if (sessionManager.token != "") {
                requestBuilder = original.newBuilder().header("Authorization", "bearer  " + sessionManager.token)
                        .method(original.method(), original.body())
            } else {
                requestBuilder = original.newBuilder()
                        .method(original.method(), original.body())
            }
        } catch (e: Exception) {
            Log.e("Error", "Received an exception", e)
        }

        return chain.proceed(requestBuilder!!.build())
    }
}
