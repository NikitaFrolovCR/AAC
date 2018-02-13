package com.example.nikita.aac.network

import com.example.nikita.aac.network.bean.UserBean
import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/users/{id}")
    fun getUser(@Path("id") id: Long): Observable<UserBean>
}