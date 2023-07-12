package com.todo.interview.model

import com.squareup.moshi.Json

/**
 * Created by Hussain on 11/07/2023.
 * Data class for CallData which is used to parse the json data from the api
 */

data class CallData(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "number") val number: String,
)
