package com.example.nikita.aac.network.modules

import com.example.nikita.aac.network.bean.UserBean
import io.reactivex.Observable

interface UserModule {
    fun getUser(id : Long): Observable<UserBean>
}
