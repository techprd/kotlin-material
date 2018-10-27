package com.techprd.material.components

import com.techprd.material.Widget
import org.w3c.dom.HTMLElement
import kotlin.dom.clear

abstract class Page : Widget() {

    override fun render(parentElement: HTMLElement) {
        parentElement.clear()
        parentElement.append(this.build())
    }
}
