package com.techprd.material
import com.techprd.material.components.Drawer
import com.techprd.material.components.AppBar
import com.techprd.material.router.Route
import com.techprd.material.router.RouteOption
import com.techprd.material.router.Router
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import kotlinx.html.id
import org.w3c.dom.HTMLElement
import kotlin.browser.document
import kotlin.dom.addClass

class MaterialApp {

    var router: Router = Router().listen()
    val rootElement: HTMLElement

    init {
        println("Initializing Kotlin Material App")

        rootElement = document.create.div("mdl-layout mdl-js-layout") {
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
            rootElement.addClass("mdl-layout--fixed-drawer")
        }
        drawer.render(rootElement)
        return this
    }

    fun addAppBar(appBar: AppBar, isFixedHeader: Boolean): MaterialApp {
        if (isFixedHeader) {
            rootElement.addClass("mdl-layout--fixed-appBar")
        }
        appBar.render(rootElement)
        return this
    }

    fun start(path: String): MaterialApp {
        rootElement.append {
            div("mdl-layout__content") {
                div("page-content") {
                    id = "main"
                }
            }
        }

        val defaultRoute = router.getRoutes()[path]!!
        router.navigate(defaultRoute)

        return this
    }
}