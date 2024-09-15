package dev.airdead.keybind.mod.network.contexts

import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayNetworkHandler
import net.minecraft.network.PacketByteBuf

/**
 * Type alias for a buffer handler function that operates within a BufferContext.
 */
typealias BufferHandler = BufferContext.() -> Unit

/**
 * Data class representing the context for handling packet buffers.
 *
 * @property buf The packet byte buffer.
 * @property client The Minecraft client instance.
 * @property handler The client play network handler, nullable.
 * @property sender The packet sender, nullable.
 */
data class BufferContext(
    val buf: PacketByteBuf,
    val client: MinecraftClient,
    val handler: ClientPlayNetworkHandler? = null,
    val sender: PacketSender? = null
) {
    /**
     * Reads an integer from the buffer.
     *
     * @return The integer read from the buffer.
     */
    fun readInt(): Int = buf.readInt()

    /**
     * Reads a double from the buffer.
     *
     * @return The double read from the buffer.
     */
    fun readDouble(): Double = buf.readDouble()

    /**
     * Reads a boolean from the buffer.
     *
     * @return The boolean read from the buffer.
     */
    fun readBoolean(): Boolean = buf.readBoolean()

    /**
     * Reads a float from the buffer.
     *
     * @return The float read from the buffer.
     */
    fun readFloat(): Float = buf.readFloat()

    /**
     * Reads a long from the buffer.
     *
     * @return The long read from the buffer.
     */
    fun readLong(): Long = buf.readLong()

    /**
     * Reads a string from the buffer.
     *
     * @return The string read from the buffer.
     */
    fun readString(): String {
        val length = buf.readInt()
        val strBytes = ByteArray(length)
        buf.readBytes(strBytes)
        return String(strBytes, Charsets.UTF_8)
    }
}