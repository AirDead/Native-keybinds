package dev.airdead.keybind.plugin.bukkit.ext

import org.bukkit.Bukkit
import org.bukkit.event.Event

internal fun Event.call() = Bukkit.getPluginManager().callEvent(this)