package dev.airdead.keybind.mod

import dev.airdead.keybind.mod.ext.isKeyPressed
import dev.airdead.keybind.mod.keyboard.Key
import dev.airdead.keybind.mod.network.ServerTransfer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.client.MinecraftClient
import net.minecraft.util.Identifier

class Main : ClientModInitializer {
    val channel = Identifier("keybinds", "keypress")
    val client = MinecraftClient.getInstance()

    override fun onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register {
            client.window?.let { window ->
                Key.entries.forEach { key ->
                    if (window.isKeyPressed(key.code)) {
                        ServerTransfer(key.code).send(channel)
                    }
                }
            }
        }
    }
}