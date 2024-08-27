package dev.airdead.keybind.plugin.tests

import dev.airdead.keybind.plugin.bukkit.event.KeyPressEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class TestListener : Listener {

    @EventHandler
    fun onTestEvent(event: KeyPressEvent) {
        event.player.sendMessage("Test event ${event.key.name}")
    }
}