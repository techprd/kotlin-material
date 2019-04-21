package com.techprd.material.router

import com.techprd.material.components.Page
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class TestPage : Page() {
    override fun build(): HTMLElement {
        return document.body!!
    }
}