package com.rybeler.exampleviewmodel.data.models

data class Thumbnail(
    val extension: String,
    val path: String
)

fun Thumbnail.asString() = "$path.$extension".replace("http","https")