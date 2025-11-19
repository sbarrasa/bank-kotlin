package com.sbarrasa.domain.cuit

object CuitEntityCodes : Map<String, CuitEntityCodes.Info> by mapOf(
   "20" to Info(Cuit.EntityType.PERSON, "Persona física (masculino)"),
   "23" to Info(Cuit.EntityType.PERSON, "Persona física (prefijo alternativo por duplicación)"),
   "24" to Info(Cuit.EntityType.PERSON, "Persona física (prefijo alternativo por duplicación)"),
   "25" to Info(Cuit.EntityType.PERSON, "Persona física (prefijo alternativo por duplicación)"),
   "26" to Info(Cuit.EntityType.PERSON, "Persona física (prefijo alternativo por duplicación)"),
   "27" to Info(Cuit.EntityType.PERSON, "Persona física (femenino)"),
   "30" to Info(Cuit.EntityType.COMPANY, "Persona jurídica (empresa o sociedad)"),
   "33" to Info(Cuit.EntityType.COMPANY, "Persona jurídica (empresa o sociedad)"),
   "34" to Info(Cuit.EntityType.COMPANY, "Persona jurídica (empresa o sociedad)")
) {

    data class Info(
       val entityType: Cuit.EntityType,
       val description: String
   )
}