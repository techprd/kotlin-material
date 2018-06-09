package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.id
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class Grid(val cellWidth: Number, val cells: ArrayList<HTMLElement>) : Widget() {

    val mainElement = document.create.div("mdl-grid")

    override fun build(): HTMLElement {

        cells.forEachIndexed { index, cell ->
            val div = document.create.div("mdl-cell mdl-cell--$cellWidth-col") {
                id = "index-$index"
            }
            div.append(cell)
            mainElement.append(div)
        }

        return mainElement
    }

    override fun render(parentElement: HTMLElement) {
        parentElement.append(this.build())
    }
}
