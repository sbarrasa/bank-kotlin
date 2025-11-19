package com.sbarrasa.domain.card

data class Bin(
   val range: IntRange,
   val brand: CardBrand,
   val cardNumberLength: Int
)