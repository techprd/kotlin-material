package com.techprd.material.components

import kotlinx.html.*

@HtmlTagMarker
fun <T, C : TagConsumer<T>> C.grid(
        cellWith: Number, repeatNumber: Int,
        block: DIV.() -> Unit = {}): T {

    return div("mdl-grid") {
        (1..repeatNumber).forEach {
            div("mdl-cell mdl-cell--$cellWith-col") {
                block()
            }
        }
    }
}