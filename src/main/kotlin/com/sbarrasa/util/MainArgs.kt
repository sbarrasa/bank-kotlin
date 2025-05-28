package com.sbarrasa.util

class MainArgs(
    args: Array<String>,
    prefix:String = "--",
    comparatorSign: Char = '='
    ) {

    val map: Map<String, String> = args
        .mapNotNull { arg ->
            val parts = arg.split(comparatorSign, limit = 2)
            if ((parts.size == 2)
                && parts[0].startsWith(prefix))
                parts[0].removePrefix(prefix) to parts[1]
            else
                null

        }
        .toMap()

    operator fun get(key: String): String? = map[key]
}