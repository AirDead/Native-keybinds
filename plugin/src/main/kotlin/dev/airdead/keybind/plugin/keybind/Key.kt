package dev.airdead.keybind.plugin.keybind

import dev.airdead.keybind.plugin.keybind.Key.entries


enum class Key(val code: Int) {
    SPACE(32),
    LEFT_ARROW(37),
    UP_ARROW(38),
    RIGHT_ARROW(39),
    DOWN_ARROW(40),
    A(65),
    B(66),
    C(67),
    D(68),
    E(69),
    F(70),
    G(71),
    H(72),
    I(73),
    J(74),
    K(75),
    L(76),
    M(77),
    N(78),
    O(79),
    P(80),
    Q(81),
    R(82),
    S(83),
    T(84),
    U(85),
    V(86),
    W(87),
    X(88),
    Y(89),
    Z(90),
    NUM_0(48),
    NUM_1(49),
    NUM_2(50),
    NUM_3(51),
    NUM_4(52),
    NUM_5(53),
    NUM_6(54),
    NUM_7(55),
    NUM_8(56),
    NUM_9(57);

    companion object {
        fun fromCode(id: Int): Key? {
            entries.forEach { key ->
                if (key.code == id) {
                    return key
                }
            }
            return null
        }
    }
}