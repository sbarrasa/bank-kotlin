package com.sbarrasa.util

inline fun <reified T : Enum<T>> enumRange(from: T, to: T? = null): List<T> {
   val entries = enumValues<T>().toList()
   val start = entries.indexOf(from)
   val end = to?.let { entries.indexOf(it) } ?: entries.lastIndex

   return if (start <= end) entries.subList(start, end + 1)
         else entries.subList(end, start + 1).reversed()
}

