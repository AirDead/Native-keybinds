package dev.airdead.keybind.plugin.bukkit.event

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

data class EscapeChangeEvent(
    val player: Player,
    val isEscaped: Boolean
) : Event(false) {

    var isCancelled: Boolean = false

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