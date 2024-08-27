package dev.airdead.keybind.plugin

import dev.airdead.keybind.plugin.network.KeyPressListener
import dev.airdead.keybind.plugin.tests.TestListener
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin() {
    override fun onEnable() {
        server.messenger.registerIncomingPluginChannel(this, "keybinds:keypress", KeyPressListener())
        server.pluginManager.registerEvents(TestListener(), this)
    }
}