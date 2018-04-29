package com.techprd.material.components

import com.techprd.material.Widget
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

    override fun render(parentElement: HTMLElement) {
        parentElement.append(this.build())
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

data class Link(val title: String, val href: String, val icon: String = "")