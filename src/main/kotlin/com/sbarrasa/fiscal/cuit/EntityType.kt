package com.sbarrasa.fiscal.cuit

import com.sbarrasa.util.id.Desc


enum class EntityType(override val description: String) : Desc {
   FISICA("persona física"),
   JURIDICA("persona juridica");
}
