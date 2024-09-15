package dev.airdead.keybind.mod.network

import dev.airdead.keybind.mod.network.contexts.BufferContext
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.minecraft.util.Identifier

fun listener(channel: Identifier, init: BufferContext.() -> Unit) {
    val context = init

    ClientPlayNetworking.registerGlobalReceiver(channel) { client, handler, buf, responseSender ->
        client.execute {
            context.invoke(BufferContext(buf, client, handler, responseSender))
        }
    }
}