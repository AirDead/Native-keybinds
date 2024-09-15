package dev.airdead.keybind.plugin.network.listeners

import dev.airdead.keybind.plugin.bukkit.event.EscapeChangeEvent
import dev.airdead.keybind.plugin.bukkit.ext.call
import dev.airdead.keybind.plugin.network.utils.wrapped
import org.bukkit.entity.Player
import org.bukkit.plugin.messaging.PluginMessageListener

internal class EscapeChangeListener : PluginMessageListener {
    override fun onPluginMessageReceived(channel: String, player: Player, buffer: ByteArray) {
        if (channel != "keybinds:escapechange") return
        val value = buffer.wrapped.int == 1

        EscapeChangeEvent(player, value).call()
    }
}