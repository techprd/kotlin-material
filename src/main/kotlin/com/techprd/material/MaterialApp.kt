package com.techprd.material

import com.techprd.material.components.layouts.Drawer
import com.techprd.material.components.AppBar
import com.techprd.material.components.layouts.footerr
import com.techprd.material.router.Route
import com.techprd.material.router.RouteOption
import com.techprd.material.router.Router
import com.techprd.material.theme.Theme
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import kotlin.browser.document
import kotlin.dom.addClass

class MaterialApp {

    var router: Router = Router().listen()
    val rootElement: HTMLElement

    init {
        println("Initializing Kotlin Material App")

        rootElement = document.create.div(Theme.mdl_layout) {
            id = "root"
        }
        document.body!!.append(rootElement)
    }

    fun configRouter(options: RouteOption): MaterialApp {
        router.config(options)
        return this
    }

    fun addRoutes(routes: List<Route>): MaterialApp {
        routes.forEach {
            router.add(it)
        }
        return this
    }

    fun addDrawer(drawer: Drawer, isFixedDrawer: Boolean): MaterialApp {
        if (isFixedDrawer) {
            rootElement.addClass(Theme.mdl_fix_drawer)
        }
        drawer.render(rootElement)
        return this
    }

    fun addAppBar(appBar: AppBar, isFixedHeader: Boolean): MaterialApp {
        if (isFixedHeader) {
            rootElement.addClass(Theme.mdl_fix_app_bar)
        }
        appBar.render(rootElement)
        return this
    }

    fun addFooter(): MaterialApp {
        rootElement.append(footerr {
            document.create.div("mdl-mega-footer__middle-section") {
                div("mdl-mega-footer__drop-down-section") {
                    input(classes = "mdl-mega-footer__heading-checkbox") {
                        type = InputType.checkBox
                        checked = true
                    }
                    h1("mdl-mega-footer__heading") {
                        +"Features"
                    }
                    ul("mdl-mega-footer__link-list") {
                        li {
                            a {
                                href = "javascript:void(0)"
                                +"About"
                            }
                        }
                        li {
                            a {
                                href = "javascript:void(0)"
                                +"Terms"
                            }
                        }
                        li {
                            a {
                                href = "javascript:void(0)"
                                +"Partners"
                            }
                        }
                        li {
                            a {
                                href = "javascript:void(0)"
                                +"Updates"
                            }
                        }
                    }
                }
            }
        }.build())
        return this
    }

    fun start(path: String): MaterialApp {

        rootElement.append {
            div(Theme.mdl_layout_content) {
                div(Theme.mdl_page_content) {
                    id = "main"
                }
            }
        }
        val defaultRoute = router.getRoutes()[path]!!
        router.navigate(defaultRoute)

        return this
    }
}
