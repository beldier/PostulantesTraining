package com.rybeler.exampleviewmodel.data.models

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Comic>,
    val returned: Int
)