package com.rybeler.exampleviewmodel.data.models

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Story>,
    val returned: Int
)