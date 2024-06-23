package com.rybeler.exampleviewmodel.data.models

data class Serie (
    val available: Int,
    val collectionURI: String,
    val items: List<Event>?,
    val returned: Int
)