package com.sopt.peekabookaos.data.entity

data class Shelf(
    val bookId: Int,
    val book: String,
    var pick: Boolean
)
