package dev.airdead.keybind.plugin

import dev.airdead.keybind.plugin.network.listeners.EscapeChangeListener
import dev.airdead.keybind.plugin.network.listeners.KeyPressListener
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {
    override fun onEnable() {
        server.messenger.registerIncomingPluginChannel(this, "keybinds:keypress", KeyPressListener())
        server.messenger.registerIncomingPluginChannel(this, "keybinds:escapechange", EscapeChangeListener())
    }
}