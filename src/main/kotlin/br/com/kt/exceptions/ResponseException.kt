package br.com.kt.exceptions

import java.util.Date

class ResponseException (
    val timeStamp: Date,
    val message: String?,
    val details: String
)