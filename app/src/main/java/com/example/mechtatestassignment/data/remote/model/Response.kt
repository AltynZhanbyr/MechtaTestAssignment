package com.example.mechtatestassignment.data.remote.model


data class Response<T>(
    val result: Boolean,
    val data: T?,
    val errors: List<String>,
)


inline fun <T> Response<T>.handle(
    onSuccess: (Response<T>) -> Unit
) {
    if (isOk) return onSuccess(this)

    if (!result && errors.isNotEmpty()) throw Exception(errors[0])

    if (errors.isEmpty()) throw Exception("Неизвестный код ошибки")
}

val Response<*>.isOk: Boolean get() = data != null && result
