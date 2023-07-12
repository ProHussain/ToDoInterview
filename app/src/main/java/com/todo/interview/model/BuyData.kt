package com.todo.interview.model

import com.squareup.moshi.Json

/**
 * Created by Hussain on 11/07/2023.
 * Data class for BuyData which is used to parse the json data from the api
 */

data class BuyData(    @field:Json(name = "id") val id: Int,
                       @field:Json(name = "name") val name: String,
                       @field:Json(name = "price") val price: Int,
                       @field:Json(name = "quantity") val quantity: Int,
                       @field:Json(name = "type") val type: Int

)
