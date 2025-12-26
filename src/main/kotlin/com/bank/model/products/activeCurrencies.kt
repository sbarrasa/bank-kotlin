package com.bank.model.products

import com.swelms.common.enums.EnumSet
import com.swelms.domain.locale.Currency

val activeCurrencies = EnumSet(
   Currency.USD,
   Currency.EUR,
   Currency.ARS,
   Currency.BRL
)