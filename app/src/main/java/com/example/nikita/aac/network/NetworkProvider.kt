package com.example.nikita.aac.network

import com.example.nikita.aac.network.modules.UserModuleImpl

object NetworkProvider {
    val userModule = UserModuleImpl()

    fun getUser(id : Long) = userModule.getUser(id)

}