package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.classes
import kotlinx.html.dom.create
import kotlinx.html.i
import kotlinx.html.js.button
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import kotlinx.browser.document

class Button : Widget() {

    var type: ButtonType = ButtonType.RAISED
    var label: String = ""
    var icon: String = ""
    var isColored: Boolean = false
    var hasRipple: Boolean = false
    var disabled: Boolean = false
    var onClickFun: (Event) -> Unit = {}

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
            ButtonType.FLAT -> Unit
            ButtonType.ICON -> cssClasses.add("mdl-button--icon")
        }

        return document.create.button {
            disabled = this@Button.disabled
            classes = cssClasses.toSet()
            onClickFunction = this@Button.onClickFun
            if (!this@Button.icon.isBlank()) {
                i("material-icons") {
                    +icon
                }
            } else {
                +label
            }
        }
    }
}

fun button(init: Button.() -> Unit): Button {
    val button = Button()
    button.init()
    return button
}

enum class ButtonType {
    MINI_FAB, FAB, RAISED, FLAT, ICON,
}
