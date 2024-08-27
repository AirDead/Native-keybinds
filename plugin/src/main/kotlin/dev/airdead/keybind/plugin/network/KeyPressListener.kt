package dev.airdead.keybind.plugin.network

import dev.airdead.keybind.plugin.bukkit.event.KeyPressEvent
import dev.airdead.keybind.plugin.bukkit.ext.call
import dev.airdead.keybind.plugin.keybind.Key
import org.bukkit.entity.Player
import org.bukkit.plugin.messaging.PluginMessageListener

class KeyPressListener : PluginMessageListener {
    override fun onPluginMessageReceived(channel: String, player: Player, buffer: ByteArray) {
        if (channel != "keybinds:keypress") return
        val key = Key.fromCode(buffer.wrapped.int) ?: return

        KeyPressEvent(player, key).call()

    }
}