package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.*
import kotlinx.html.ButtonType
import kotlinx.html.dom.create
import kotlinx.html.js.dialog
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLDialogElement
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class Dialog : Widget() {
    var titleText = ""
    lateinit var htmlDialog: HTMLDialogElement

    override fun build(): HTMLElement {
        htmlDialog = document.create.dialog("mdl-dialog") {
            h5("mdl-dialog__title") {
                +titleText
            }
            div("mdl-dialog__content") {
                p {
                    +"content"
                }
            }
            div("mdl-dialog__actions") {
                button {
                    classes = setOf("mdl-button")
                    type = ButtonType.button
                    onClickFunction = { htmlDialog.close() }
                    +"Ok"
                }
            }
        }
        return htmlDialog
    }

    fun showDialog() {
        htmlDialog.showModal()
    }
}

fun dialog(init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog()
    dialog.init()
    return dialog
}
