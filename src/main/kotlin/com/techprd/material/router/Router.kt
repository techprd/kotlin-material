package com.techprd.material.router

import kotlin.browser.window

open class Router {

    var routes: LinkedHashMap<String, Route> = linkedMapOf()
    var root: String = "/"
    lateinit var mode: RouteMode

    fun getRoutes(): LinkedHashMap<String, Route> {
        return this.routes
    }

    fun config(options: RouteOption): Router {
        this.mode = options.mode
        if (!options.root.isBlank()) {
            this.root = '/' + clearSlashes(options.root) + '/'
        }
        return this
    }

    fun clearSlashes(path: String): String {
        return path.replace("^/".toRegex(), "").replace("/\$".toRegex(), "")
    }

    fun getFragment(): String {
        var fragment: String
        if (this.mode == RouteMode.HISTORY) {
            fragment = this.clearSlashes(
                    decodeURI(window.location.pathname + window.location.search)
            )
            fragment = fragment.replace("\\?(.*)\$".toRegex(), "")
            if (this.root != "/") {
                fragment = fragment.replace(this.root.toRegex(), "")
            }
        } else {
            val match = window.location.href.match("#(.*)\$").orEmpty()
            fragment = if (match.isNotEmpty()) match[1] else ""
        }
        return this.clearSlashes(fragment)
    }

    fun add(route: Route): Router {
        val path = clearSlashes(route.path)
        this.routes[path] = route
        return this
    }

    fun remove(routeKey: String): Router {
        this.routes.remove(routeKey)
        return this
    }

    fun flush(): Router {
        this.routes.clear()
        this.root = "/"
        this.mode = RouteMode.HISTORY
        return this
    }

    fun listen(): Router {
        val router = this
        window.onhashchange = {
            val path: String = router.getFragment()
            router.navigate(path, path, null)
        }
        return this
    }

    fun navigate(path: String, title: String = "", data: Any?): Router {

        val route: Route? = this.routes[this.clearSlashes(path)]
        if (route != null) {
            if (data != null) route.data = data

            if (this.mode == RouteMode.HISTORY) {
                window.history.pushState(route.data, title, this.clearSlashes(route.path))
                route.goTo()
            } else {
                window.location.href =
                        "${window.location.href.replace("#(.*)\$".toRegex(), "")}#/" + route.path + "/"
                route.goTo()
            }
        } else {
            error("There is no route configured for path: $path")
        }
        return this
    }

    fun navigate(route: Route) {
        this.navigate(route.path, route.path, route.data)
    }
}

external fun decodeURI(encodedURI: String): String

class RouteOption(var mode: RouteMode, var root: String)

enum class RouteMode {
    HISTORY, HASH
}
