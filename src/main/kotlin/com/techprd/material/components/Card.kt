package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import org.w3c.dom.*
import org.w3c.dom.events.MouseEvent
import kotlin.browser.document

class Card(val titleText: String, val supportText: String, val shadowDepth: Int = 2) : Widget() {

    override fun build(): HTMLElement {
        return document.create.div("mdl-card mdl-shadow--${shadowDepth}dp") {
            div("mdl-card__title") {
                h2("mdl-card__title-text") {
                    +titleText
                }
            }
            div("mdl-card__media") {
                img {
                    width = "100%"
                    height = "140"
                    src = "https://getmdl.io/assets/demos/welcome_card.jpg"
                }
            }
            div("mdl-card__supporting-text mdl-card--border") {
                +supportText
            }
            div("mdl-card__actions") {
                a {
                    +"Related Action"
                }
            }
        }

    }
}
