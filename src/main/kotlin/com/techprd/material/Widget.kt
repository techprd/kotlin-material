package com.techprd.material

import org.w3c.dom.HTMLElement

abstract class Widget {

    val data: ArrayList<Any> = arrayListOf()
    var parent: HTMLElement? = null
    val children: ArrayList<Widget> = arrayListOf()

    fun append(widget: Widget): Widget {
        children.add(widget)
        widget.parent = this.build()
        return this
    }

    fun appendTo(widget: Widget): Widget {
        widget.append(this)
        return this
    }

    fun insertBefore(): Widget {
        return this
    }

    abstract fun build(): HTMLElement
    abstract fun render(parentElement: HTMLElement)
}