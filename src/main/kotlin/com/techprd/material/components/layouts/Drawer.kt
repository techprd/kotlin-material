package com.techprd.material.components.layouts

import com.techprd.material.Widget
import com.techprd.material.components.data.Link
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class Drawer(val drawerTitle: String, val links: List<Link>) : Widget() {
    override fun build(): HTMLElement {
        return document.create.div("mdl-layout__drawer") {
            span("mdl-layout-title") {
                +drawerTitle
            }
            drawerNavigation(links)
        }
    }
}

fun DIV.drawerNavigation(links: List<Link>) {

    ul("mdl-list") {
        links.forEach { link ->
            li("mdl-list__item") {
                span("mdl-list__item-primary-content") {
                    i("material-icons mdl-list__item-icon") {
                        +link.icon
                    }
                    a {
                        classes = setOf("mdl-navigation__link")
                        href = link.href
                        +link.title
                    }
                }
            }
        }
    }
}

