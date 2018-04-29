package com.techprd.material.router

import kotlin.test.*

class RouterTest {

    private val router = Router()

    @Test
    fun clearSlashes() {
        assertEquals(router.clearSlashes("/somePath/some/"), "somePath/some")
        assertEquals(router.clearSlashes("somePath/some"), "somePath/some")
        assertEquals(router.clearSlashes("somePath/"), "somePath")
        assertEquals(router.clearSlashes("/somePath"), "somePath")
        assertEquals(router.clearSlashes("/somePath/"), "somePath")
    }

    @Test
    fun addRoute() {

        router.add(Route("/test", TestPage(), null))
        assertTrue { router.getRoutes().isNotEmpty() }
    }

    @Test
    fun removeRoute() {
        router.remove("/test")
        assertTrue { router.getRoutes().isEmpty() }
    }

    @Test
    fun testNavigate() {
        assertFails({
            router.navigate("/test", "title", null)
        })
    }
}