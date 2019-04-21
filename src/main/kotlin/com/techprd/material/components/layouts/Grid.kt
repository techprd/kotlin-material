package com.techprd.material.components.layouts

import com.techprd.material.Widget
import com.techprd.material.components.Button
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.stream.createHTML
import org.w3c.dom.CloseEventInit
import org.w3c.dom.HTMLElement
import kotlin.browser.document

@HtmlTagMarker
class Grid(val cellWidth: Number, val cells: ArrayList<HTMLElement>) : Widget() {

    val mainElement = document.create.div("mdl-grid")

    override fun build(): HTMLElement {

        cells.forEachIndexed { index, cell ->
            val div = document.create.div("mdl-cell mdl-cell--$cellWidth-col") {
                id = "index-$index"
                div { }
            }
            div.append(cell)
            mainElement.append(div)
        }

        return mainElement
    }
}

