package com.example.nikita.aac.network.modules

import com.example.nikita.aac.network.Api
import com.example.nikita.aac.network.RestClient

class UserModuleImpl : UserModule {
    private var api: Api = RestClient.getInstance().create(Api::class.java)
    override fun getUser(id : Long) = api.getUser(id)
}