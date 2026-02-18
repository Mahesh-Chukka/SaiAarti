package com.mahameet.apps.saiaarti.version

fun isVersionLess(a: String, b: String): Boolean {
    val partsA = a.split(".").map { it.toIntOrNull() ?: 0 }
    val partsB = b.split(".").map { it.toIntOrNull() ?: 0 }
    for (i in 0 until maxOf(partsA.size, partsB.size)) {
        val pa = partsA.getOrElse(i){0}
        val pb = partsB.getOrElse(i){0}
        if (pa < pb) return true
        if (pa > pb) return false
    }
    return false
}