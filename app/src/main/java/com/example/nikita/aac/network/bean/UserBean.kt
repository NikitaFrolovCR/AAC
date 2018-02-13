package com.example.nikita.aac.network.bean

import com.fasterxml.jackson.annotation.JsonProperty

class UserBean(@JsonProperty("id")
              var id: Long? = null,
              @JsonProperty("type")
              var type: String? = null,
              @JsonProperty("url")
              var url: String? = null)