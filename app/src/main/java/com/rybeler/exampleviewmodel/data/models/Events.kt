package com.rybeler.exampleviewmodel.data.models

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Event>,
    val returned: Int
)