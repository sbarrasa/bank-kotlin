package com.sbarrasa.cuit

import kotlinx.serialization.Serializable


object EntityCodes : Map<String, EntityCodes.Info> by mapOf(
   "20" to Info(EntityType.FISICA, "Persona física (masculino)"),
   "23" to Info(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "24" to Info(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "25" to Info(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "26" to Info(EntityType.FISICA, "Persona física (prefijo alternativo por duplicación)"),
   "27" to Info(EntityType.FISICA, "Persona física (femenino)"),
   "30" to Info(EntityType.JURIDICA, "Persona jurídica (empresa o sociedad)"),
   "33" to Info(EntityType.JURIDICA, "Persona jurídica (empresa o sociedad)"),
   "34" to Info(EntityType.JURIDICA, "Persona jurídica (empresa o sociedad)")
) {

   fun validate(entityCode: String?){
      if(entityCode == null)
         throw FiscalException("debe especificar un código de entidad")

      if(this[entityCode] == null)
         throw FiscalException("$entityCode es un código de entidad inválido")
   }
   @Serializable
   data class Info(
      val entityType: EntityType,
      val description: String
   )
}