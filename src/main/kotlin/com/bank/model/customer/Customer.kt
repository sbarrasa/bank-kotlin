package com.bank.model.customer

import com.sbarrasa.fiscal.cuit.Cuit
import com.sbarrasa.util.id.Id
import com.sbarrasa.person.Name
import com.sbarrasa.person.Nombrable
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer(
   override var id: Int? = null,
   private var fullName: Name? = null,
   var birthDay: LocalDate? = null,
   var gender: Gender? = null,
   var cuit: Cuit? = null)
: Id<Int?>, Nombrable by fullName ?: Name()