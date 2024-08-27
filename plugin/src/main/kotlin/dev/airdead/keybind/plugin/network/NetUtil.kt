@file:Suppress("NOTHING_TO_INLINE")

package dev.airdead.keybind.plugin.network

import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

inline fun ByteBuffer.readInt(): Int = int

inline fun ByteBuffer.readFloat(): Float = float

fun ByteBuffer.readString(): String {
    val length = this.int
    val bytes = ByteArray(length)
    this[bytes]
    return String(bytes, StandardCharsets.UTF_8)
}

val ByteArray.wrapped: ByteBuffer
    get() = ByteBuffer.wrap(this)