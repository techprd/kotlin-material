package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.*
import kotlin.browser.document

class AppBar(val headerTitle: String, val links: List<Link>) : Widget() {

    override fun build(): HTMLElement {
        return document.create.header("mdl-layout__header") {
            div("mdl-layout__header-row") {
                span("mdl-layout-title") { +headerTitle }
                div("mdl-layout-spacer")
                navigationView(links)
            }
        }
    }

    override fun render(parentElement: HTMLElement) {
        parentElement.append(this.build())
    }
}

fun DIV.navigationView(links: List<Link>) {

    nav("mdl-navigation") {
        links.forEach { link ->
            a {
                classes = setOf("mdl-navigation__link")
                href = link.href
                +link.title
            }
        }
    }
}