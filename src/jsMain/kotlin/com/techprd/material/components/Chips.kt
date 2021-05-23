package com.techprd.material.components

import com.techprd.material.Widget
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import kotlinx.browser.document

class Chip : Widget() {

    val cssClasses = arrayListOf("mdl-chip")
    var label = ""
    var deletable = false
    var isButton = false
    var isContactChip = false
    var contactChipImageSrc = ""
    var contactChipChars = ""
    var contactIconClasses = setOf("mdl-chip__contact", "mdl-color--teal", "mdl-color-text--white")

    override fun build(): HTMLElement {
        if (isContactChip) cssClasses.add("mdl-chip--contact")
        return if (isButton) {
            document.create.button {
                commonBodyContent()
            }
        } else {
            document.create.span {
                commonBodyContent()
            }
        }
    }

    private fun HtmlBlockInlineTag.commonBodyContent() {
        classes = cssClasses.toSet()
        if (isContactChip) {
            if (contactChipImageSrc.isNotBlank()) {
                img {
                    classes = contactIconClasses
                    src = contactChipImageSrc
                }
            } else {
                span {
                    classes = contactIconClasses
                    +contactChipChars
                }
            }
        }
        span {
            classes = setOf("mdl-chip__text")
            +label
        }
        if (deletable) {
            button {
                classes = setOf("mdl-chip__action")
                i {
                    classes = setOf("material-icons")
                    +"cancel"
                }
            }
        }
    }
}

fun chip(init: Chip.() -> Unit): Chip {
    val chip = Chip()
    chip.init()
    return chip
}
