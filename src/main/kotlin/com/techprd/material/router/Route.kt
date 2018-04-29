package com.techprd.material.router

import com.techprd.material.components.Page
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class Route(val path: String, val page: Page, var data: Any?) {
    fun goTo() {
        val root = document.getElementById("main") as HTMLElement
        this.page.data.add(data!!)
        this.page.render(root)
    }
}