package com.sbarrasa.cuit

import com.sbarrasa.util.id.Desc
import com.sbarrasa.util.id.EnumDescMap

enum class EntityType(override val description: String) : Desc {
   FISICA("persona física"),
   JURIDICA("persona juridica");

   companion object : EnumDescMap<EntityType> {
      override val values = EntityType.entries
   }
}
