package com.techprd.material.components.data

import org.w3c.dom.HTMLElement

data class Tab(val title: String, val content: HTMLElement, var isActive: Boolean, val icon: String = "")
