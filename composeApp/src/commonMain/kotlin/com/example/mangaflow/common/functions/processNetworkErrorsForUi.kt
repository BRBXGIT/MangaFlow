package com.example.mangaflow.common.functions

import com.example.mangaflow.core.data.network.utils.NetworkError

fun processNetworkErrorsForUi(error: NetworkError): String {
    return when(error) {
        NetworkError.REQUEST_TIMEOUT -> "Error: timeout"
        NetworkError.UNAUTHORIZED -> "Error: unauthorized"
        NetworkError.CONFLICT -> "Error: conflict"
        NetworkError.TOO_MANY_REQUESTS -> "Give manga dex a little rest, try in 5 minutes :)"
        NetworkError.NO_INTERNET -> "Error: Internet. Please connect to it :)"
        NetworkError.PAYLOAD_TOO_LARGE -> "Error: payload to large"
        NetworkError.SERVER_ERROR -> "Error: server error, something wrong with manga dex :("
        NetworkError.SERIALIZATION -> "Error: serialization"
        NetworkError.UNKNOWN -> "Error: unknown"
    }
}