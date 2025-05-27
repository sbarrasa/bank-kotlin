package com.sbarrasa.util.mapper

import kotlin.test.*
class ObjectMapperTest{
    data class SourceObject(val name: String?=null, val age: Int?=null)
    data class TargetObject(var edad: Int?=null, var nombre: String?=null)

    val mapper = ObjectMapper<SourceObject, TargetObject>() {
        bind(SourceObject::name, TargetObject::nombre)
        bind(SourceObject::age, TargetObject::edad)
    }
    @Test
    fun mapWithallData(){
        val source = SourceObject("Juan", 20)
        val target = TargetObject(nombre = "Pepe", edad = 42)

        assertEquals("Pepe", target.nombre)
        mapper.map(source, target)
        assertEquals("Juan", target.nombre)
    }

    @Test
    fun mapWithNullData(){
        val source = SourceObject(age =20)
        val target = TargetObject(nombre = "Pepe",  edad= 42)

        assertEquals("Pepe", target.nombre)
        mapper.map(source, target)
        assertEquals("Pepe", target.nombre)
    }

}
