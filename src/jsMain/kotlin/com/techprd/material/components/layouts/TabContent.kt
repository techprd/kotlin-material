package com.techprd.material.components.layouts

import com.techprd.material.Widget
import com.techprd.material.components.data.Tab
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.id
import org.w3c.dom.HTMLElement
import kotlinx.browser.document

class TabContent(val tab: Tab) : Widget() {
    override fun build(): HTMLElement {
        return document.create.div("mdl-tabs__panel") {
            if (tab.isActive) classes += "is-active"
            id = tab.title
            div {
                +"content:"
                tab.content
            }
        }
    }


}
