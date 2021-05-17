package com.techprd.material.components.layouts

import com.techprd.material.Widget
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import kotlinx.browser.document

open class Footer : Widget() {
    override fun build(): HTMLElement {
        return document.create.footer("mdl-mega-footer") {

        }
    }

}

fun footerr(block: Footer.() -> Unit): Footer {
    val footer = Footer()
    footer.block()
    return footer
}
