package dev.airdead.keybind.plugin.bukkit.event

import dev.airdead.keybind.plugin.keybind.Key
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

data class KeyPressEvent(
    val player: Player,
    val key: Key
) : Event(false) {
    override fun getHandlers(): HandlerList {
        return Companion.handlers
    }

    companion object {
        private val handlers = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handlers
        }
    }
}