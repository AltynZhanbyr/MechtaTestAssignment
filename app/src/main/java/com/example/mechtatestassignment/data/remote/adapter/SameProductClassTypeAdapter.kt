package com.example.mechtatestassignment.data.remote.adapter

import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.SameProducts
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class SameProductClassTypeAdapter :
    JsonDeserializer<List<SameProducts>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        ctx: JsonDeserializationContext
    ): List<SameProducts> {
        val vals: MutableList<SameProducts> = ArrayList()
        if (json.isJsonArray) {
            for (e in json.getAsJsonArray()) {
                vals.add(ctx.deserialize<Any>(e, SameProducts::class.java) as SameProducts)
            }
        } else if (json.isJsonObject) {
            vals.add(ctx.deserialize<Any>(json, SameProducts::class.java) as SameProducts)
        } else {
            throw RuntimeException("Unexpected JSON type: " + json.javaClass)
        }
        return vals
    }
}