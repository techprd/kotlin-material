package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.dom.clear
import org.w3c.dom.HTMLElement

abstract class Page : Widget() {

    override fun render(parentElement: HTMLElement) {
        parentElement.clear()
        parentElement.append(this.build())
    }
}
