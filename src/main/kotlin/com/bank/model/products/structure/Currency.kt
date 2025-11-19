package com.bank.model.products.structure

import com.sbarrasa.common.id.Desc

//TODO: armar currency con carga desde archivo
//TODO: armar lista de countries

enum class Currency(override val description: String) : Desc {
   ARS("pesos"),
   USD("dólares"),
   EUR("euros")

}