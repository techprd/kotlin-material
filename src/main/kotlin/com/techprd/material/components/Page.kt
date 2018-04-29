package com.techprd.material.components

import com.techprd.material.Widget
import org.w3c.dom.Element
import org.w3c.dom.HTMLCollection
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLSlotElement
import org.w3c.dom.css.CSSStyleDeclaration
import org.w3c.dom.events.Event
import kotlin.dom.clear

abstract class Page : Widget() {

    override fun render(parentElement: HTMLElement) {
        parentElement.clear()
        parentElement.append(this.build())
    }
}