package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.classes
import kotlinx.html.dom.create
import kotlinx.html.i
import kotlinx.html.js.button
import kotlinx.html.label
import org.w3c.dom.HTMLElement
import kotlin.browser.document


fun button(init: Button.() -> Unit): Button {
    val button = Button()
    button.init()
    return button
}


class Button : Widget() {

    var type: ButtonType = ButtonType.RAISED
    var label: String = ""
    var icon: String = ""
    var isColored: Boolean = false
    var hasRipple: Boolean = false
    var isEnabled: Boolean = false

    override fun build(): HTMLElement {

        val cssClasses = arrayListOf("mdl-button", "mdl-js-button")

        when {
            isColored -> cssClasses.add("mdl-button--colored")
        }
        when {
            hasRipple -> cssClasses.add("mdl-js-ripple-effect")
        }

        when (type) {
            ButtonType.FAB -> cssClasses.add("mdl-button--fab")
            ButtonType.RAISED -> cssClasses.add("mdl-button--raised")
            ButtonType.MINI_FAB -> cssClasses.add("mdl-button--fab mdl-button--mini-fab")
            ButtonType.FLAT -> cssClasses.add("mdl-button--raised")
            ButtonType.ICON -> cssClasses.add("mdl-button--icon")
        }

        return document.create.button {
            classes = cssClasses.toSet()
            if (!this@Button.icon.isBlank()) {
                i("material-icons") {
                    +icon
                }
            } else {
                +label
            }
        }
    }

    override fun render(parentElement: HTMLElement) {
        parentElement.append(this.build())
    }
}

enum class ButtonType {
    MINI_FAB, FAB, RAISED, FLAT, ICON,
}