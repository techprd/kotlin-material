package com.techprd.material.components.layouts

import com.techprd.material.Widget
import com.techprd.material.components.data.Tab
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import kotlinx.browser.document
import kotlinx.dom.clear

class Tabs(val tabs: List<Tab>) : Widget() {

    private val wrapper = document.create.div()

    override fun build(): HTMLElement {

        val mainElement = document.create.div("mdl-tabs mdl-js-tabs mdl-js-ripple-effect is-upgraded") {
            div("mdl-tabs__tab-bar") {
                tabs.onEach { tab ->
                    tabHeader(tab)
                }
            }
        }

        tabs.onEach { tab ->
            val content = document.create.div("mdl-tabs__panel") {
                if (tab.isActive) classes += "is-active"
                id = tab.title
            }
            content.append(tab.content)
            mainElement.append(content)
        }

        wrapper.append(mainElement)
        return wrapper
    }

    private fun reRender() {
        wrapper.clear()
        this.build()
    }

    private fun selectTab(tab: Tab): (Event) -> Unit {
        return {
            tabs.forEach {
                it.isActive = false
            }
            tab.isActive = true
            this.reRender()
        }
    }

    fun DIV.tabHeader(tab: Tab) {
        return a("javascript:void(0)", "", "mdl-tabs__tab") {
            if (tab.isActive) classes += "is-active"
            +tab.title
            onClickFunction = selectTab(tab)
        }
    }
}


