package com.sbarrasa.registry

import kotlin.test.*

class RegistryTest {

    @Test
    fun registerInstance() {
        val registry = Registry<String, String>()
        val instance = "test instance"

        registry.register("key1", instance)

        assertEquals(instance, registry.get("key1"))
    }

    @Test
    fun registerConstructor() {
        val registry = Registry<String, String>()

        registry.register("key1") { "created instance" }

        assertEquals("created instance", registry.create("key1"))
    }

    @Test
    fun getLazyCreatesInstance() {
        val registry = Registry<String, String>()

        registry.register("key1") { "lazy instance" }

        val result = registry.get("key1")
        assertEquals("lazy instance", result)
    }

    @Test
    fun getCachesInstance() {
        val registry = Registry<String, Int>()
        var counter = 0

        registry.register("key1") { ++counter }

        val first = registry.get("key1")
        val second = registry.get("key1")

        assertEquals(1, first)
        assertEquals(1, second)
        assertEquals(1, counter)
    }

    @Test
    fun unregisterRemovesAll() {
        val registry = Registry<String, String>()

        registry.register("key1", "instance")
        registry.register("key1") { "constructor" }

        registry.unregister("key1")

        assertFailsWith<RegistryException> {
            registry.get("key1")
        }
    }

    @Test
    fun createThrowsWhenNotRegistered() {
        val registry = Registry<String, String>()

        val exception = assertFailsWith<RegistryException> {
            registry.create("nonexistent")
        }

        assertTrue(exception.message?.contains("nonexistent") ?: false)
    }

    @Test
    fun getThrowsWhenNotRegistered() {
        val registry = Registry<String, String>()

        assertFailsWith<RegistryException> {
            registry.get("nonexistent")
        }
    }

    @Test
    fun registerInstanceOverwrites() {
        val registry = Registry<String, String>()

        registry.register("key1", "first")
        registry.register("key1", "second")

        assertEquals("second", registry.get("key1"))
    }

    @Test
    fun registerConstructorOverwrites() {
        val registry = Registry<String, String>()

        registry.register("key1") { "first" }
        registry.register("key1") { "second" }

        assertEquals("second", registry.create("key1"))
    }

    @Test
    fun createAlwaysReturnsNew() {
        val registry = Registry<String, Int>()
        var counter = 0

        registry.register("key1") { ++counter }

        val first = registry.create("key1")
        val second = registry.create("key1")

        assertEquals(1, first)
        assertEquals(2, second)
    }

    @Test
    fun worksWithComplexTypes() {
        data class TestClass(val value: String)

        val registry = Registry<String, TestClass>()

        registry.register("key1") { TestClass("test") }

        val result = registry.get("key1")
        assertEquals("test", result.value)
    }
}
