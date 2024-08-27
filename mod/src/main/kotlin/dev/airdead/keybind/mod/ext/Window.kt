package dev.airdead.keybind.mod.ext

import dev.airdead.keybind.mod.keyboard.keyStates
import net.minecraft.client.util.InputUtil
import net.minecraft.client.util.Window

internal fun Window.isKeyPressed(key: Int): Boolean {
    val isPressed = InputUtil.isKeyPressed(handle, key)
    return if (isPressed) {
        keyStates.add(key)
    } else {
        keyStates.remove(key)
        false
    }
}
