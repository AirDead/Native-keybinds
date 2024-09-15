package dev.airdead.keybind.mod

import dev.airdead.keybind.mod.ext.isKeyPressed
import dev.airdead.keybind.mod.keyboard.Key
import dev.airdead.keybind.mod.network.ServerTransfer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.client.gui.screen.GameMenuScreen
import net.minecraft.client.gui.screen.Screen
import net.minecraft.util.Identifier

class Main : ClientModInitializer {
    private val channelKeyPress = Identifier("keybinds", "keypress")
    private val channelScreenChange = Identifier("keybinds", "escapechange")
    private var screenBefore: Screen? = null

    override fun onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register { client ->
            client.window?.let { window ->
                Key.entries
                    .filter { window.isKeyPressed(it.code) }
                    .forEach { ServerTransfer(it.code).send(channelKeyPress) }
            }

            val currentScreen = client.currentScreen
            val screenChangedToMenu = currentScreen is GameMenuScreen && screenBefore !is GameMenuScreen
            val screenClosedFromMenu = screenBefore is GameMenuScreen && currentScreen !is GameMenuScreen

            when {
                screenChangedToMenu -> ServerTransfer(1).send(channelScreenChange)
                screenClosedFromMenu -> ServerTransfer(0).send(channelScreenChange)
            }

            screenBefore = currentScreen
        }
    }
}
