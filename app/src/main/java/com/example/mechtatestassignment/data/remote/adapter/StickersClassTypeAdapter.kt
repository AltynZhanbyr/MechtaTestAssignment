package com.example.mechtatestassignment.data.remote.adapter

import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.Stickers
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type


class StickersClassTypeAdapter :
    JsonDeserializer<List<Stickers>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        ctx: JsonDeserializationContext
    ): List<Stickers> {
        val vals: MutableList<Stickers> = ArrayList()
        if (json.isJsonArray) {
            for (e in json.getAsJsonArray()) {
                vals.add(ctx.deserialize<Any>(e, Stickers::class.java) as Stickers)
            }
        } else if (json.isJsonObject) {
            vals.add(ctx.deserialize<Any>(json, Stickers::class.java) as Stickers)
        } else {
            throw RuntimeException("Unexpected JSON type: " + json.javaClass)
        }
        return vals
    }
}