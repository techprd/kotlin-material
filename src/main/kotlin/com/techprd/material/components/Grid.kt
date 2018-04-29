package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.id
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class Grid(val cellWidth: Number, val repeatNumber: Int, val block: HTMLElement) : Widget() {

    val cells = arrayListOf<HTMLElement>()
    val mainElement = document.create.div("mdl-grid")

    override fun build(): HTMLElement {

        (1..repeatNumber).forEach { index ->
            val div = document.create.div("mdl-cell mdl-cell--$cellWidth-col") {
                id = "index-$index"
            }
            div.append(block.cloneNode(true))
            mainElement.append(div)
        }

        return mainElement
    }

    override fun render(parentElement: HTMLElement) {
        parentElement.append(this.build())
    }
}
