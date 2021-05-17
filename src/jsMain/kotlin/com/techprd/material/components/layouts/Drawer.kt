package com.techprd.material.components.layouts

import com.techprd.material.Widget
import com.techprd.material.components.data.Link
import com.techprd.material.theme.Theme
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import kotlinx.browser.document

class Drawer(val drawerTitle: String, val links: List<Link>) : Widget() {
    override fun build(): HTMLElement {
        return document.create.div(Theme.mdl_layout_drawer) {
            span(Theme.mdl_layout_title) {
                +drawerTitle
            }
            drawerNavigation(links)
        }
    }

    private fun DIV.drawerNavigation(links: List<Link>) {
        ul(Theme.mdl_list) {
            links.forEach { link ->
                li(Theme.mdl_list_item) {
                    span(Theme.mdl_list_item_primary) {
                        i(Theme.mdl_list_icon) {
                            +link.icon
                        }
                        a {
                            classes = setOf(Theme.mdl_nav_link)
                            href = link.href
                            +link.title
                        }
                    }
                }
            }
        }
    }
}
